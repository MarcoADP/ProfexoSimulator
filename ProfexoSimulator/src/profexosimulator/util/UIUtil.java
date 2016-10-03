package profexosimulator.util;


import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import profexosimulator.model.Jogador;

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

    public static Callback<TableColumn<Jogador, Double>, TableCell<Jogador, Double>> getCellFactory() {
        return param -> new TableCell<Jogador, Double>() {
            @Override
            public void updateItem(Double value, boolean empty) {
                super.updateItem(value, empty);
                if (value == null) {
                    setText(null);
                } else {
                    setText(String.format("%.2f", value.doubleValue()));
                }
            }
        };
    }
}
