package com.marllon.vieira.vergili.sudoku.board;


import com.marllon.vieira.vergili.sudoku.services.LogicasSudoku;
import com.marllon.vieira.vergili.sudoku.services.Matrix;

import java.util.Random;

/***
 * Classe responsável por criar os templates do Tabuleiro.
 * Pelo que pesquisei, e li no wikipedia a descrição de como funciona o jogo
 * e do que entendi, criarei 2 constantes aqui.
 * Uma será o tabuleiro principal, sendo uma matriz 9x9
 *
 * e a outra, um tabuleiro "regional" que tem 3x3 posições.
 *
 */

public class BoardTemplate {


    //Tamanho fixo do array = 9
    private final int TAMANHOFIXO_ARRAY = 9;

    //Construtor vazio - Sem parâmetros
    public BoardTemplate(){}

    Random numerosAleatorios = new Random();

    //Instanciando as Matrizes
    Matrix<Integer> tabuleiroPrincipal = new Matrix<>(9,9);
    Matrix<Integer> tabuleiroRegional = new Matrix<>(3,3);

    //Métodos Getters... Não tem setters pois não faz sentido
    public Matrix<Integer> getTabuleiroPrincipal() {
        return tabuleiroPrincipal;
    }

    public Matrix<Integer> getTabuleiroRegional() {
        return tabuleiroRegional;
    }



    public void inserirValorCampoArray(int linha, int coluna, Integer valor){
        tabuleiroPrincipal.adicionarElemento(linha, coluna, valor);
    }



    //Método para selecionar um bloco dentro de uma região do tabuleiro, dentro dos blocos 3x3

    public void preencherBlocoRegiao(int linha, int coluna){
        //Encontrar o canto superior esquerdo da matriz 3x3
        int inicioLinha = (linha / 3) * 3;
        int inicioColuna = (coluna / 3) * 3;

        for(int linhaArr = 0; linhaArr < 3; linhaArr++){
            for(int colArr = 0; colArr < 3; colArr++){
                Integer valor = tabuleiroPrincipal.obterElemento(inicioLinha + linhaArr, inicioColuna + colArr);
                tabuleiroRegional.adicionarElemento(linhaArr,colArr,valor);
            }
        }
    }


    /**
     * Este é o método principal para gerar o tabuleiro do Sudoku no jogo.
     *Ele ja irá gerar os valores aleatórios, conforme existe no sudoku
     * na hora de começar o game
     *
     * */
    public void iniciarTabuleiro(LogicasSudoku regrasSudoku, int qtdPistasIniciais){

        //Correção de BUG - Inicializar todos os campos com 0
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tabuleiroPrincipal.adicionarElemento(i, j, 0);
            }
        }

        int camposPreenchidos = 0;
        int tentativas = 0;
        int maxTentativas = qtdPistasIniciais * 20;

        //Enquanto o valor dos campos for menor que as pistas iniciais que passado no parâmetro..
        while (camposPreenchidos < qtdPistasIniciais && tentativas < maxTentativas){
            int linha = numerosAleatorios.nextInt(9);
            int coluna = numerosAleatorios.nextInt(9);
            int valor = numerosAleatorios.nextInt(9) + 1; //Valores até 10

            //chamando o método "podecolocarnumero" para verificar se não terá conflito
            //de gerar o valor aleatório num campo que já tme valor
            if (regrasSudoku.podeColocarNumero(linha,coluna,valor,tabuleiroPrincipal)){
                tabuleiroPrincipal.adicionarElemento(linha,coluna,valor);
                camposPreenchidos++;
            }
            tentativas++;
        }
    }


}
