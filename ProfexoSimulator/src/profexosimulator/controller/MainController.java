package profexosimulator.controller;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import profexosimulator.ProfexoSimulator;
import profexosimulator.model.Profexo;
import profexosimulator.util.Util;

import java.util.Arrays;

public class MainController {

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
    public void handleMenuItemSair(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    public void handleMenuItemSobre(ActionEvent actionEvent) {

    }

    @FXML
    public void handleMenuItemNovoJogo(ActionEvent actionEvent) {
        ProfexoSimulator.novoJogo();
    }

    @FXML
    public void handleBtnProximo(ActionEvent actionEvent) {

    }
}
