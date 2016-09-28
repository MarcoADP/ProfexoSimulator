package profexosimulator.controller;


import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import profexosimulator.model.Equipe;
import profexosimulator.model.Profexo;
import profexosimulator.util.UIUtil;
import profexosimulator.util.Util;

public class ParametrosController {

    @FXML
    private VBox root;
    @FXML
    private TextField fieldNomeProfexo;
    @FXML
    private ChoiceBox<Profexo.Mentalidade> choiceMentalidade;
    @FXML
    private ChoiceBox<Profexo.Tatica> choiceTatica;
    @FXML
    private TextField fieldNomeTime;

    @FXML
    private void initialize() {
        choiceMentalidade.getItems().setAll(Profexo.Mentalidade.values());
        choiceMentalidade.getSelectionModel().select(0);

        choiceTatica.getItems().setAll(Profexo.Tatica.values());
        choiceTatica.getSelectionModel().select(0);
    }

    @FXML
    private void handleBtnContinuar() {
        if (UIUtil.validarFields(fieldNomeProfexo, fieldNomeTime)) {
            return;
        }

        MainController main = MainController.INSTANCE;

        Profexo profexo = new Profexo(fieldNomeProfexo.getText(), choiceMentalidade.getValue(), choiceTatica.getValue());
        Equipe equipe = new Equipe(fieldNomeTime.getText(), profexo);
        main.getSimulador().iniciarEquipes(equipe);

        main.getElencoController().setSimulador(main.getSimulador());

        main.proximaTela(main.getElencoController().getRoot());
    }

    @FXML
    private void handleBtnNomeProfexoAleatorio() {
        fieldNomeProfexo.setText(Util.gerarNomeAleatorio());
    }

    @FXML
    private void handleBtnNomeTimeAleatorio() {
        fieldNomeTime.setText(Util.gerarNomeTimeAleatorio());
    }

    public VBox getRoot() {
        return root;
    }

}
