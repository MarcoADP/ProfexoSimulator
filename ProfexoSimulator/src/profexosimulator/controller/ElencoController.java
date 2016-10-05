package profexosimulator.controller;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import profexosimulator.fuzzy.Simulador;
import profexosimulator.model.Jogador;
import profexosimulator.util.UIUtil;
import sun.applet.Main;

public class ElencoController {

    @FXML
    private VBox root;
    @FXML
    public TableView<Jogador> tabelaElenco;
    @FXML
    public TableColumn colAlturaElenco;
    @FXML
    public Label labelElencoJogador;

    private Simulador simulador;

    @FXML
    public void initialize() {
        Callback<TableColumn<Jogador, Double>, TableCell<Jogador, Double>> cellFactory = UIUtil.getCellFactory();

        colAlturaElenco.setCellFactory(cellFactory);
    }

    @FXML
    public void handleBtnGerarElenco() {
        simulador.getEquipeJogador().formarElenco();
        tabelaElenco.setItems(FXCollections.observableList(simulador.getEquipeJogador().getPlantel()));
    }

    @FXML
    public void handleBtnContinuar() {
        if (tabelaElenco.getItems().isEmpty()) {
            return;
        }

        MainController main = MainController.INSTANCE;
        main.proximaTela(main.getPartidaController().getRoot());
    }

    @FXML
    public void handleBtnVoltar() {
        MainController main = MainController.INSTANCE;
        main.voltarTela(main.getParametrosController().getRoot());
    }

    public VBox getRoot() {
        return root;
    }

    public void setSimulador(Simulador simulador) {
        this.simulador = simulador;

        labelElencoJogador.setText("Elenco - " + simulador.getEquipeJogador().getNome());
    }
}
