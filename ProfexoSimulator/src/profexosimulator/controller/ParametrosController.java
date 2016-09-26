package profexosimulator.controller;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import profexosimulator.model.Profexo;
import profexosimulator.util.Util;

import java.util.Arrays;

public class ParametrosController {

    @FXML
    private VBox root;
    @FXML
    private TextField fieldNomeProfexo;
    @FXML
    private ChoiceBox choiceMentalidade;
    @FXML
    private ChoiceBox choiceTatica;
    @FXML
    private TextField fieldNomeTime;
    @FXML
    private Button btnProximo;

    @FXML
    private void initialize() {
        choiceMentalidade.setItems(FXCollections.observableList(Arrays.asList(Profexo.Mentalidade.values())));
        choiceMentalidade.getSelectionModel().select(0);

        choiceTatica.setItems(FXCollections.observableList(Arrays.asList(Util.TATICAS)));
        choiceTatica.getSelectionModel().select(0);
    }

    @FXML
    public void handleBtnProximo(ActionEvent actionEvent) {
        MainController main = MainController.INSTANCE;
        main.proximaTela(main.getElencoController().getRoot());
    }

    public VBox getRoot() {
        return root;
    }

    public TextField getFieldNomeProfexo() {
        return fieldNomeProfexo;
    }

    public ChoiceBox getChoiceMentalidade() {
        return choiceMentalidade;
    }

    public ChoiceBox getChoiceTatica() {
        return choiceTatica;
    }

    public TextField getFieldNomeTime() {
        return fieldNomeTime;
    }
}
