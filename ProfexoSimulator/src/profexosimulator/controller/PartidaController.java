package profexosimulator.controller;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import profexosimulator.ProfexoSimulator;
import profexosimulator.fuzzy.Fuzzy;
import profexosimulator.fuzzy.Simulador;

public class PartidaController {

    @FXML
    private VBox root;
    @FXML
    private ChoiceBox choiceQualidadeTime;
    @FXML
    private ChoiceBox choiceQualidadeAdversario;
    @FXML
    private ChoiceBox choiceEstadio;
    @FXML
    private ChoiceBox choiceTorcida;
    @FXML
    private ToggleGroup toggleGroup;
    @FXML
    private RadioButton radioBtnCentroGravidade;
    @FXML
    private RadioButton radioBtnPrimeiroMaximos;
    @FXML
    private RadioButton radioBtnMediaMaximos;
    @FXML
    private Label labelResultado;

    private Simulador simulador;
    private Fuzzy fuzzy;

    private Timeline fontAnim;

    private DoubleProperty fontSize = new SimpleDoubleProperty(1);

    @FXML
    public void initialize() {
        choiceQualidadeTime.getItems().addAll(Fuzzy.Variavel.IN_QUALIDADE_TIME.getValores());
        choiceQualidadeTime.getSelectionModel().select(0);

        choiceQualidadeAdversario.getItems().addAll(Fuzzy.Variavel.IN_QUALIDADE_ADVERSARIO.getValores());
        choiceQualidadeAdversario.getSelectionModel().select(0);

        choiceEstadio.getItems().addAll(Fuzzy.Variavel.IN_QUALIDADE_ESTADIO.getValores());
        choiceEstadio.getSelectionModel().select(0);

        choiceTorcida.getItems().addAll(Fuzzy.Variavel.IN_QUALIDADE_TORCIDA.getValores());
        choiceTorcida.getSelectionModel().select(0);

        radioBtnCentroGravidade.setText(Fuzzy.METODO_CENTRO_DE_GRAVIDADE);
        radioBtnPrimeiroMaximos.setText(Fuzzy.METODO_PRIMEIRO_DOS_MAXIMOS);
        radioBtnMediaMaximos.setText(Fuzzy.METODO_MEDIA_DOS_MAXIMOS);

        labelResultado.setVisible(false);
        fontSize.addListener((observable, oldValue, newValue) -> ProfexoSimulator.INSTANCE.getStage().sizeToScene());

        KeyFrame start = new KeyFrame(Duration.ZERO,
                new KeyValue(labelResultado.opacityProperty(), 0),
                new KeyValue(fontSize, 1));

        KeyFrame end = new KeyFrame(Duration.millis(500),
                new KeyValue(labelResultado.opacityProperty(), 1),
                new KeyValue(fontSize, 48));

        fontAnim = new Timeline(start, end);

        labelResultado.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString(), ";"));
    }

    @FXML
    public void handleBtnExecutar() {
        //fuzzy.setMetodoDefuzzy(((RadioButton)toggleGroup.getSelectedToggle()).getText());

        labelResultado.setVisible(true);
        fontAnim.playFromStart();

        String resultado = "Vitória!";
        labelResultado.setText(resultado);
        labelResultado.getStyleClass().removeIf(s -> s.contains("color"));

        switch (resultado) {
            case "Vitória!":
                labelResultado.getStyleClass().add("color-green");
                break;
            case "Derrota!":
                labelResultado.getStyleClass().add("color-red");
                break;
        }

    }

    @FXML
    public void handleBtnVoltar() {
        MainController main = MainController.INSTANCE;
        main.voltarTela(main.getElencoController().getRoot());
    }

    public void handleBtnGraficoQualidadeTime() {
        fuzzy.mostrarGraficoVariavel(Fuzzy.VAR_INPUT_QUALIDADE_TIME);
    }

    public void handleBtnGraficoQualidadeAdversario() {
        fuzzy.mostrarGraficoVariavel(Fuzzy.VAR_INPUT_QUALIDADE_ADVERSARIO);
    }

    public void handleBtnGraficoEstadio() {
        fuzzy.mostrarGraficoVariavel(Fuzzy.VAR_INPUT_QUALIDADE_ESTADIO);
    }

    public void handleBtnGraficoTorcida() {
        fuzzy.mostrarGraficoVariavel(Fuzzy.VAR_INPUT_QUALIDADE_TORCIDA);
    }

    public void handleBtnGraficoPossibilidade() {
        fuzzy.mostrarGraficoVariavel(Fuzzy.VAR_OUTPUT_POSSIBILIDADE);
    }

    public void handleBtnGraficoPossibilidadeDeffuzzy() {
        fuzzy.mostrarGraficoDefuzzy(Fuzzy.VAR_OUTPUT_POSSIBILIDADE);
    }

    public VBox getRoot() {
        return root;
    }

    public void setSimulador(Simulador simulador) {
        this.simulador = simulador;
        this.fuzzy = simulador.getFuzzy();
    }
}
