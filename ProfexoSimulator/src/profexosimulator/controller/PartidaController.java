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
    private Slider sliderQualidadeTime;
    @FXML
    private Slider sliderQualidadeAdversario;
    @FXML
    private Slider sliderEstadio;
    @FXML
    private Slider sliderTorcida;
    @FXML
    private Spinner<Number> spinnerQualidadeTime;
    @FXML
    private Spinner<Number> spinnerQualidadeAdversario;
    @FXML
    private Spinner<Number> spinnerEstadio;
    @FXML
    private Spinner<Number> spinnerTorcida;
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
    @FXML
    private Label labelResultadoInfo;
    @FXML
    private CheckBox checkBoxGraficos;

    private Simulador simulador;
    private Fuzzy fuzzy;

    private Timeline fontAnim;

    @FXML
    public void initialize() {
        configurarSpinnersSliders();

        radioBtnCentroGravidade.setText(Fuzzy.METODO_CENTRO_DE_GRAVIDADE);
        radioBtnPrimeiroMaximos.setText(Fuzzy.METODO_PRIMEIRO_DOS_MAXIMOS);
        radioBtnMediaMaximos.setText(Fuzzy.METODO_MEDIA_DOS_MAXIMOS);

        checkBoxGraficos.selectedProperty().addListener((observable, oldValue, newValue) -> fuzzy.setDialogFisVisible(newValue));

        configurarAnimacaoLabelResultado();
    }

    private void configurarAnimacaoLabelResultado() {
        labelResultado.setVisible(false);

        DoubleProperty fontSize = new SimpleDoubleProperty(1);

        KeyFrame start = new KeyFrame(Duration.ZERO,
                new KeyValue(labelResultado.opacityProperty(), 0),
                new KeyValue(fontSize, 1));

        KeyFrame end = new KeyFrame(Duration.millis(400),
                new KeyValue(labelResultado.opacityProperty(), 1),
                new KeyValue(fontSize, 48));

        fontAnim = new Timeline(start, end);

        labelResultado.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString(), ";"));
    }

    private void configurarSpinnersSliders() {
        spinnerQualidadeTime.getValueFactory().valueProperty().bindBidirectional(sliderQualidadeTime.valueProperty());
        spinnerQualidadeAdversario.getValueFactory().valueProperty().bindBidirectional(sliderQualidadeAdversario.valueProperty());
        spinnerEstadio.getValueFactory().valueProperty().bindBidirectional(sliderEstadio.valueProperty());
        spinnerTorcida.getValueFactory().valueProperty().bindBidirectional(sliderTorcida.valueProperty());
    }

    @FXML
    public void handleBtnExecutar() {
        String metodoFuzzy = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
        double qualidadeTime = sliderQualidadeTime.getValue();
        double qualidadeAdversario = sliderQualidadeAdversario.getValue();
        double estadio = sliderEstadio.getValue();
        double torcida = sliderTorcida.getValue();

        fuzzy.setMetodoDefuzzy(metodoFuzzy);
        fuzzy.executar(qualidadeTime, qualidadeAdversario, estadio, torcida);

        String resultado = String.format("%.4f", fuzzy.getResultado());
        labelResultado.setText(resultado);

        labelResultado.setVisible(true);
        fontAnim.playFromStart();
        fontAnim.setOnFinished(event -> ProfexoSimulator.INSTANCE.getStage().sizeToScene());

        labelResultadoInfo.setText(fuzzy.getInfoResultado());
    }

    public void handleBtnGraficoMostrarAnimacao() {
        fuzzy.mostrarAnimacao();
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
