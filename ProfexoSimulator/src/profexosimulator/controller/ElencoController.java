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

public class ElencoController {

    @FXML
    private VBox root;
    @FXML
    public TableView<Jogador> tabelaElenco;
    @FXML
    public TableView<Jogador> tabelaAdversario;
    @FXML
    public TableColumn colAlturaElenco;
    @FXML
    public TableColumn colAlturaAdversario;
    @FXML
    public Label labelElencoJogador;
    @FXML
    public Label labelElencoAdversario;

    private Simulador simulador;

    @FXML
    public void initialize() {
        Callback<TableColumn<Jogador, Double>, TableCell<Jogador, Double>> cellFactory = param -> new TableCell<Jogador, Double>() {
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

        colAlturaElenco.setCellFactory(cellFactory);
        colAlturaAdversario.setCellFactory(cellFactory);
    }

    @FXML
    public void handleBtnGerarElenco() {
        simulador.getEquipeJogador().formarElenco();
        tabelaElenco.setItems(FXCollections.observableList(simulador.getEquipeJogador().getPlantel()));
    }

    @FXML
    public void handleBtnContinuar() {

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

        //tabelaElenco.getItems().addAll(simulador.getEquipeJogador().getPlantel());
        tabelaAdversario.setItems(FXCollections.observableList(simulador.getEquipeAdversario().getPlantel()));

        labelElencoJogador.setText("Elenco - " + simulador.getEquipeJogador().getNome());
        labelElencoAdversario.setText("Elenco Adversário - " + simulador.getEquipeAdversario().getNome());
    }
}
