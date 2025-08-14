package com.marllon.vieira.vergili.sudoku.board;


import com.marllon.vieira.vergili.sudoku.services.Matrix;

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
        tabuleiroPrincipal.adicionarELemento(linha, coluna, valor);
    }



    //Método para selecionar um bloco dentro de uma região do tabuleiro, dentro dos blocos 3x3

    public void preencherBlocoRegiao(int linha, int coluna){
        //Encontrar o canto superior esquerdo da matriz 3x3
        int inicioLinha = (linha / 3) * 3;
        int inicioColuna = (coluna / 3) * 3;

        for(int linhaArr = 0; linhaArr < 3; linhaArr++){
            for(int colArr = 0; colArr < 3; colArr++){
                Integer valor = tabuleiroPrincipal.obterElemento(inicioLinha + linhaArr, inicioColuna + colArr);
                tabuleiroRegional.adicionarELemento(linhaArr,colArr,valor);
            }
        }
    }


}
