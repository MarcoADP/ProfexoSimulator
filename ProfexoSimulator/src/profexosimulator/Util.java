package profexosimulator;

import java.util.Random;

public class Util {
    
    
    
    static String gerarNomeAleatorio(){
        String[] listaNomes = new String[]{"André", "Armando", "Tonhão", "Amaral", "Romário", "Paulo", "Junior Baiano", "Odvan", 
            "Nilson", "Clébão", "Douglas", "Pelé", "Rivaldo", "Pará", "Kléber", "Fábio", "Marco", "Thiago", "Jumar"
        
        }; 
        
        String[] listaSobrenomes = new String[]{ "Souza", "Santos", "Silva", "Almeida", "Balada", "Borges", " Baiano",
            "Camanducaia", "Varzea", "Camargo"
        
        };
        
        Random random = new Random();
        return listaNomes[random.nextInt(listaNomes.length)] + " " + listaSobrenomes[random.nextInt(listaSobrenomes.length)];
        
    }

    static int gerarNumeroAleatorio(int min, int max){
        Random random = new Random();
        int retorno = random.nextInt(max-min) + min;
        
        return retorno;
    }

    static String gerarPosicaoAleatoria(){
        String[] listaPosicoes = new String[]{"Goleiro", "Zagueiro", "Libero", "Lateral", 
            "Volante", "Armador", "Meia",
            "Ponta", "Atacante", "Centro Avante"
        };
        Random random = new Random();
        return listaPosicoes[random.nextInt(listaPosicoes.length)];
    }
    
}
