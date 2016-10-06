package profexosimulator.controller;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import profexosimulator.ProfexoSimulator;
import profexosimulator.fuzzy.Fuzzy;
import profexosimulator.fuzzy.Simulador;

public class PartidaController {

    @FXML
    private VBox root;
    @FXML
    private ChoiceBox<String> choiceQualidadeTime;
    @FXML
    private ChoiceBox<String> choiceQualidadeAdversario;
    @FXML
    private ChoiceBox<String> choiceEstadio;
    @FXML
    private ChoiceBox<String> choiceTorcida;
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
        String metodoFuzzy = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
        String qualidadeTime = choiceQualidadeTime.getValue();
        String qualidadeAdversario = choiceQualidadeAdversario.getValue();
        String estadio = choiceEstadio.getValue();
        String torcida = choiceTorcida.getValue();

        fuzzy.setMetodoDefuzzy(metodoFuzzy);
        fuzzy.executar(qualidadeTime, qualidadeAdversario, estadio, torcida);

        String resultado = fuzzy.getResultado() + "";
        labelResultado.setText(resultado);

        labelResultado.setVisible(true);
        fontAnim.playFromStart();
    }

    public void handleBtnGraficoQualidadeTime() {
        fuzzy.mostrarGraficoVariavel(Fuzzy.Variavel.IN_QUALIDADE_TIME.getNome());
    }

    public void handleBtnGraficoQualidadeAdversario() {
        fuzzy.mostrarGraficoVariavel(Fuzzy.Variavel.IN_QUALIDADE_ADVERSARIO.getNome());
    }

    public void handleBtnGraficoEstadio() {
        fuzzy.mostrarGraficoVariavel(Fuzzy.Variavel.IN_QUALIDADE_ESTADIO.getNome());
    }

    public void handleBtnGraficoTorcida() {
        fuzzy.mostrarGraficoVariavel(Fuzzy.Variavel.IN_QUALIDADE_TORCIDA.getNome());
    }

    public void handleBtnGraficoPossibilidade() {
        fuzzy.mostrarGraficoVariavel(Fuzzy.Variavel.OUT_POSSIBILIDADE.getNome());
    }

    public void handleBtnGraficoPossibilidadeDeffuzzy() {
        fuzzy.mostrarGraficoDefuzzy(Fuzzy.Variavel.OUT_POSSIBILIDADE.getNome());
    }

    public VBox getRoot() {
        return root;
    }

    public void setSimulador(Simulador simulador) {
        this.simulador = simulador;
        this.fuzzy = simulador.getFuzzy();
    }
}
