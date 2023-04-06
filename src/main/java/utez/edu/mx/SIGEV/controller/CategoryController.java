package utez.edu.mx.SIGEV.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import utez.edu.mx.SIGEV.entity.Category;
import utez.edu.mx.SIGEV.services.CategoryService;
import utez.edu.mx.SIGEV.util.BlacklistController;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listCategories(Model model, RedirectAttributes redirectAttributes, Pageable pageable,
                                 Authentication authentication, HttpSession session) {
        Page<Category> listCategory = categoryService
                .listPagination(PageRequest.of(pageable.getPageNumber(), 10, Sort.by("id").ascending()));
        model.addAttribute("listCategories", listCategory);
        return "category/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createCategory(Model model, RedirectAttributes redirectAttributes, Category category) {
        return "category/create";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String categoryEdit(Model model, RedirectAttributes redirectAttributes, @PathVariable("id") long id,
                               Category category) {
        Category tmp = categoryService.findById(id);
        if (!tmp.equals(null)) {
            model.addAttribute("category", tmp);
            return "category/edit";
        } else {
            redirectAttributes.addFlashAttribute("msg_error", "El Servicio público solicitado no existe.");
            return "redirect:/category/list";
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String categoryUpdate(Model model, RedirectAttributes redirectAttributes, @PathVariable("id") long id,
                                 Category category) {
        Category tmp = categoryService.findById(id);
        if (!tmp.equals(null)) {
            if (!BlacklistController.checkBlacklistedWords(tmp.getDescription())) {
                tmp.setDescription(category.getDescription());
                boolean res = categoryService.save(tmp);
                if (res) {
                    redirectAttributes.addFlashAttribute("msg_success", "Servicio Público actualizado");
                    return "redirect:/category/list";
                } else {
                    redirectAttributes.addFlashAttribute("msg_error",
                            "Ocurrió un error al actualizar el Servicio Público");
                }
            } else {
                redirectAttributes.addFlashAttribute("msg_error", "Ingresó una o más palabras prohibidas");
            }
        } else {
            redirectAttributes.addFlashAttribute("msg_error", "El Servicio público solicitado no existe.");
        }
        return "redirect:/category/edit/" + id;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Model model, RedirectAttributes redirectAttributes, Category category) {
        if (!categoryService.exists(category.getDescription())) {
            if (!BlacklistController.checkBlacklistedWords(category.getDescription())) {
                boolean res = categoryService.save(category);
                if (res) {
                    redirectAttributes.addFlashAttribute("msg_success", "Servicio Público registrado exitosamente");
                    return "redirect:/category/list";
                } else {
                    redirectAttributes.addFlashAttribute("msg_error", "No se pudo registrar el Servicio Público");
                }
            } else {
                redirectAttributes.addFlashAttribute("msg_error", "Ingresó una o más palabras prohibidas");
            }
        } else {
            redirectAttributes.addFlashAttribute("msg_error", "Este servicio público ya existe");
        }
        return "redirect:/category/create";
    }
}
