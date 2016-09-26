package profexosimulator.controller;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import profexosimulator.model.Equipe;
import profexosimulator.model.Jogador;
import profexosimulator.model.Profexo;

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

    private Equipe equipe;
    private Equipe adversario;
    private Profexo profexo;

    @FXML
    public void initialize() {
        profexo = new Profexo();
        equipe = new Equipe("Birl", profexo);
        adversario = new Equipe("Adversário", new Profexo());
        
        tabelaAdversario.setItems(FXCollections.observableList(adversario.getPlantel()));

        Callback<TableColumn<Jogador, Double>, TableCell<Jogador, Double>> cellFactory = param -> new TableCell<Jogador, Double>() {
            @Override
            public void updateItem(Double value, boolean empty) {
                super.updateItem(value, empty) ;
                if (value==null) {
                    setText(null);
                } else {
                    setText(String.format("%.3f", value.doubleValue()));
                }
            }
        };

        colAlturaElenco.setCellFactory(cellFactory);
        colAlturaAdversario.setCellFactory(cellFactory);

    }

    @FXML
    public void handleBtnGerarElenco(ActionEvent actionEvent) {
        equipe = new Equipe(equipe.getNome(), profexo);
        tabelaElenco.setItems(FXCollections.observableList(equipe.getPlantel()));
    }

    @FXML
    public void handleBtnProximo(ActionEvent actionEvent) {

    }

    @FXML
    public void handleBtnVoltar(ActionEvent actionEvent) {
        MainController main = MainController.INSTANCE;
        main.voltarTela(main.getParametrosController().getRoot());
    }

    public VBox getRoot() {
        return root;
    }
}
