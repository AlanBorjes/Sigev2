package utez.edu.mx.SIGEV.model.responses;

import lombok.Data;

@Data
public class InfoToast {
    private String title;
    private String message;
    private String typeToast;
}
