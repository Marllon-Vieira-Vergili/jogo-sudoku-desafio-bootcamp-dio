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
    private BoardTemplate(){}



    //Instanciando as Matrizes
    Matrix<Integer> tabuleiroPrincipal = new Matrix<>(9,9);
    Matrix<Integer> tabuleiroRegional = new Matrix<>(3,3);


    /*
    Código Comentado... vou utilizar minha classe Matrix para instância, aproveitando
    ela de quando fiz o curso de estrutura de dados

    Tabuleiro, constante (não se alterará)
    * com 9x9. Esse é o tabuleiro principal

    public final static int [][] tabuleiroPrincipal = {
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0}
    };


    public static final int [][] tabuleiroRegional ={
            {0,0,0},
            {0,0,0},
            {0,0,0}

    };
    /*
     */
}
