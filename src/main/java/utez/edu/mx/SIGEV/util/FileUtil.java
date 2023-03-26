package utez.edu.mx.SIGEV.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtil {
    
    public static String saveFile(MultipartFile multipartFile, String path) {
        String fileName = multipartFile.getOriginalFilename();
        try {
            String filePath = path + "/" + fileName.replaceAll(" ", "").replaceAll("-", "").replace("°", "");
            File file = new File(filePath);
            multipartFile.transferTo(file);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "null";
        }
    }

}
