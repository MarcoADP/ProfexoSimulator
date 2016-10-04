#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* str_time;
char* str_adversario;
char* str_estadio;
char* str_torcida;

void comparaTime(int num){
	switch (num){
		case 1:
			str_time = "pessimo";
			break;
		case 2:
			str_time = "ruim";
			break;
		case 3:
			str_time = "regular";
			break;
		case 4:
			str_time = "bom";
			break;
		case 5:
			str_time = "otimo";
			break;
	}
}

void comparaAdversario(int num){
	switch (num){
		case 1:
			str_adversario = "juvenil";
			break;
		case 2:
			str_adversario = "amador";
			break;
		case 3:
			str_adversario = "normal";
			break;
		case 4:
			str_adversario = "dificil";
			break;
		case 5:
			str_adversario = "alemanha";
			break;
	}
}

void comparaEstadio(int num){
	switch (num){
		case 1:
			str_estadio = "varzea";
			break;
		case 2:
			str_estadio = "ruim";
			break;
		case 3:
			str_estadio = "jogavel";
			break;
		case 4:
			str_estadio = "bom";
			break;
		case 5:
			str_estadio = "tapete";
			break;
	}
}
	
void comparaTorcida(int num){
	switch (num){
		case 1:
			str_torcida = "pessimo";
			break;
		case 2:
			str_torcida = "ruim";
			break;
		case 3:
			str_torcida = "regular";
			break;
		case 4:
			str_torcida = "bom";
			break;
		case 5:
			str_torcida = "otimo";
			break;
	}
}

int main (){
	
	FILE* arquivo;
	FILE* novo;
	char lixo[50];
	int time;
	int adversario;
	int torcida;
	int estadio;
	char resultado[50];
	int lixoint;
	float lixofloat;
	
	arquivo = fopen("planilha.tsv", "r");
	novo = fopen("resultado.txt", "w");
	
	fscanf(arquivo, "%s %s %s %s %s %s %s %s %s", lixo, lixo, lixo, lixo, lixo, lixo, lixo, lixo, lixo);
	//printf("%s", lixo);
	int i;
	for(i = 1; i < 626; i++){
		fscanf(arquivo, "%d %d %d %d %s %s %s %d %d %d %f %s %s", &time, &adversario, &estadio, &torcida, lixo, lixo, lixo, &lixoint, &lixoint, &lixoint, &lixofloat, lixo, resultado);
		comparaTime(time);
		comparaAdversario(adversario);
		comparaEstadio(estadio);
		comparaTorcida(torcida);
		//printf("Time => %d \t String => %s\n", time, str_time);
		//printf("Time => %d\nAdversario => %d \nEstadio => %d \nTorcida => %d \nResultado => %s", time, adversario, estadio, torcida, resultado);
		//printf("\n\n");
		fprintf(novo, "%s %d %s %s %s %s %s %s %s %s %s %s\n", "RULE", i, ": IF Qualidade_Time IS", str_time, "AND Qualidade_adversario IS", str_adversario,  "AND Estadio IS", str_estadio, "AND Torcida IS", str_torcida, "THEN Possibilidade IS", resultado);
	}
	
	return 0;
}