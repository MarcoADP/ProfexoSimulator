package profexosimulator.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import profexosimulator.model.Jogador;

public class PartidaController {

    @FXML
    private VBox root;
    @FXML
    public TableView<Jogador> tabelaEscalacao;
    @FXML
    public TableView<Jogador> tabelaAdversario;
    @FXML
    public Label labelEscalacaoJogador;
    @FXML
    public Label labelEscalacaoAdversario;

    @FXML
    public void initialize() {

    }

    @FXML
    public void handleBtnGerarElenco() {

    }

    @FXML
    public void handleBtnContinuar() {

    }

    @FXML
    public void handleBtnVoltar() {
        MainController main = MainController.INSTANCE;
        main.voltarTela(main.getElencoController().getRoot());
    }

    public VBox getRoot() {
        return root;
    }

}
