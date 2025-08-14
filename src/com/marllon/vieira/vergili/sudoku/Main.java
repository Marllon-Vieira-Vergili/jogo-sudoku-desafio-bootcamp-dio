package com.marllon.vieira.vergili.sudoku;


import com.marllon.vieira.vergili.sudoku.board.BoardTemplate;
import com.marllon.vieira.vergili.sudoku.exceptions.JaTemValorNoCampoInformadoExc;
import com.marllon.vieira.vergili.sudoku.services.LogicasSudoku;

import java.util.Scanner;

/**
 * Aqui será definido a classe Main para
 * execução e teste do código
 * */
public class Main {
    public static void main(String[] args) {


        //instanciar tabuleiro e as regras
        BoardTemplate tabuleiro = new BoardTemplate();
        LogicasSudoku regrasSudoku = new LogicasSudoku();
        Scanner scan = new Scanner(System.in);

        //Gerar o tabuleiro sudoku pegando as regras do sudoku, e passando 25 pistas iniciais
        tabuleiro.iniciarTabuleiro(regrasSudoku,25);

        boolean continuar = true;

        while(continuar){
            System.out.println("Tabuleiro atual: ");
            System.out.println(tabuleiro.getTabuleiroPrincipal());

            System.out.println("Vamos começar o jogo?");

            System.out.println("=================");


            System.out.println("Digite em qual linha voce quer adicionar o valor: ");
            int linha = scan.nextInt();


            System.out.println("Digite em qual coluna voce quer adicionar o valor: ");
            int coluna = scan.nextInt();



            System.out.println("Digite o valor que você quer adicionar agora: ");
            int valor = scan.nextInt();

            //jogar o método colocar número dentro do try, pois ele pode dar o exception de insercao do array que ja tem valor
            try{
                regrasSudoku.colocarNumero(linha,coluna,valor, tabuleiro.getTabuleiroPrincipal());
                System.out.println("Número inserido no campo solicitado.");
            }catch (JaTemValorNoCampoInformadoExc e){
                System.out.println("Já tem um número inserido neste campo informado.");
            }

            //Perguntando se o usuario quer continuar jogando
            System.out.println("Deseja continuar jogando? (s/n) : ");
            String resposta = scan.next().toLowerCase(); //Detectar pelo lower case;

            if (resposta.equals("n")){
                continuar = false;
            }else{
                continuar = true;
            }

        }
        //Se terminar tudo, ou o usuário não quiser continuar, mostrar como ficou o tabuleiro final

        System.out.println("Tabuleiro final: ");
        System.out.println(tabuleiro.getTabuleiroPrincipal());


    }
}
