package profexosimulator.controller;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
    private ParametrosController parametrosController;
    private ElencoController elencoController;

    public static MainController INSTANCE;

    private Simulador simulador;

    @FXML
    private void initialize() {
        INSTANCE = this;
        simulador = new Simulador();
        inicializarControllerJogadores();
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
                new KeyValue(novo.translateXProperty(), width*fator),
                new KeyValue(antigo.translateXProperty(), 0));

        KeyFrame end = new KeyFrame(Duration.seconds(0.2),
                new KeyValue(novo.translateXProperty(), 0),
                new KeyValue(antigo.translateXProperty(), -width*fator));

        Timeline slide = new Timeline(start, end);
        slide.play();
    }

    private void inicializarControllerJogadores() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/elenco.fxml"));
        try {
            Pane pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        elencoController = loader.getController();
    }

    public ParametrosController getParametrosController() {
        return parametrosController;
    }

    public ElencoController getElencoController() {
        return elencoController;
    }

    public Simulador getSimulador() {
        return simulador;
    }
}
