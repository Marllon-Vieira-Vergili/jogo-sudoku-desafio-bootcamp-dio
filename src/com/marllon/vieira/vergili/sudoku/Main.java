package com.marllon.vieira.vergili.sudoku;


import com.marllon.vieira.vergili.sudoku.board.BoardTemplate;
import com.marllon.vieira.vergili.sudoku.services.LogicasSudoku;

/**
 * Aqui será definido a classe Main para
 * execução e teste do código
 * */
public class Main {
    public static void main(String[] args) {


        //instanciar tabuleiro e as regras
        BoardTemplate tabuleiro = new BoardTemplate();
        LogicasSudoku regrasSudoku = new LogicasSudoku();

        //Iniciando o tabuleiro com todos os valores em 0
        tabuleiro.getTabuleiroPrincipal().preencherMatrizToda(0);

        //Testando pra ver se mostrou o tabuleiro
        System.out.println(tabuleiro.getTabuleiroPrincipal());


        //Testando se os métodos da lógica insere
        regrasSudoku.colocarNumero(0, 0, 5, tabuleiro.getTabuleiroPrincipal());
        regrasSudoku.colocarNumero(0, 1, 3, tabuleiro.getTabuleiroPrincipal());
        regrasSudoku.colocarNumero(1, 0, 6, tabuleiro.getTabuleiroPrincipal());
    }
}
