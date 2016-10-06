package profexosimulator.controller;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import profexosimulator.ProfexoSimulator;
import profexosimulator.fuzzy.Simulador;

import java.io.IOException;

public class MainController {

    @FXML
    private BorderPane borderPane;

    @FXML
    private PartidaController partidaController;
    private SobreController sobreController;

    public static MainController INSTANCE;

    private Simulador simulador;

    @FXML
    private void initialize() {
        INSTANCE = this;
        simulador = new Simulador();

        sobreController = inicializarController("../view/sobre.fxml");

        partidaController.setSimulador(simulador);
    }

    @FXML
    public void handleMenuItemSair() {
        Platform.exit();
    }

    @FXML
    private void handleMenuItemSobre() {
        Alert sobre = new Alert(Alert.AlertType.INFORMATION);
        sobre.setTitle("Sobre");
        sobre.setHeaderText(null);
        sobre.setGraphic(null);
        sobre.getDialogPane().setContent(sobreController.getRoot());
        sobre.showAndWait();
    }

    @FXML
    private void handleMenuItemNovoJogo() {
        ProfexoSimulator.novoJogo();
    }

    public void proximaTela(Pane novo) {
        mostrarTela(novo, 1);
    }

    public void voltarTela(Pane novo) {
        mostrarTela(novo, -1);
    }

    private void mostrarTela(Pane novo, int fator) {
        Node antigo = borderPane.getCenter();

        borderPane.setCenter(novo);
        ProfexoSimulator.INSTANCE.getStage().sizeToScene();

        double width = borderPane.getWidth();

        KeyFrame start = new KeyFrame(Duration.ZERO,
                new KeyValue(novo.translateXProperty(), width * fator),
                new KeyValue(antigo.translateXProperty(), 0));

        KeyFrame end = new KeyFrame(Duration.seconds(0.2),
                new KeyValue(novo.translateXProperty(), 0),
                new KeyValue(antigo.translateXProperty(), -width * fator));

        Timeline slide = new Timeline(start, end);
        slide.play();
    }

    private <T> T inicializarController(String fxml_path) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml_path));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loader.getController();
    }

    public PartidaController getPartidaController() {
        return partidaController;
    }

    public Simulador getSimulador() {
        return simulador;
    }
}
