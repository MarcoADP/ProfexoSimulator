package profexosimulator.util;


import javafx.scene.control.TextField;

public class UIUtil {

    private UIUtil() {}

    public static boolean validarFields(TextField... fields) {
        boolean temErros = false;
        for (TextField field : fields) {
            field.getStyleClass().remove("field-erro");
            if (field.getText().trim().isEmpty()) {
                field.getStyleClass().add("field-erro");
                temErros = true;
            }
        }
        return temErros;
    }
}
