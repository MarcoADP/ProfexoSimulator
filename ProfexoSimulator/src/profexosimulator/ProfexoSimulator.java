package profexosimulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProfexoSimulator extends Application {

    public static final String TITULO = "Profexô Simulator";
    public static final int LARGURA = 400;
    public static final int ALTURA = 280;

    public static ProfexoSimulator INSTANCE;

    private Stage stage;

    @Override
    public void start(Stage stage) {
        INSTANCE = this;
        this.stage = stage;

        try {
            Parent root = FXMLLoader.load(getClass().getResource("view/main.fxml"));

            Scene scene = new Scene(root);

            stage.setMinHeight(ALTURA);
            stage.setMinWidth(LARGURA);
            stage.setTitle(TITULO);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void novoJogo() {
        INSTANCE.getStage().close();
        INSTANCE.start(new Stage());
    }

    public Stage getStage() {
        return stage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    /*public static void main(String[] args) {
        //String nome = "Odvan";
        //String posicao1 = "Zagueiro";
        //String posicao2 = "Líbero";
        //int idade = 35;
        //Jogador Odvan = new Jogador(nome, idade, posicao1);
        //Odvan.mostrarAtributos();

        //Jogador jog1 = new Jogador();
        //jog1.mostrarAtributos();

        Equipe equipe = new Equipe("Portuguesa", new Profexo());
        //equipe.mostrarEquipe();
        equipe.escalarTime();
        equipe.mostrarEscalacao();
        //equipe.mostrarEquipe();
    }*/
}
