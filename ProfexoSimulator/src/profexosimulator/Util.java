/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profexosimulator;

import java.util.Random;

/**
 *
 * @author marvin
 */
public class Util {
    
    
    
    static String gerarNomeAleatorio(){
        String[] listaNomes = new String[]{"André Almeida", "Armando Marques", "Antônio Carlos", "Amaral", "Romário", "Paulo Almeida", 
            "Junior Baiano", "Odvan", "Nilson", "Clébão", "Douglas Maestro", "Pelé", "Rivaldo", "Pará", "Kléber Pereira", "Fábio Costa"
        
        }; 
        
        Random random = new Random();
        return listaNomes[random.nextInt(listaNomes.length)];
        
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
