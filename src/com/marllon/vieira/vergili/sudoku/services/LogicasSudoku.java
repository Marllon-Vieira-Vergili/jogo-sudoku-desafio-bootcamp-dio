package com.marllon.vieira.vergili.sudoku.services;

import com.marllon.vieira.vergili.sudoku.exceptions.JaTemValorNoCampoInformadoExc;



/**
 *
 *
 * */
public class LogicasSudoku {



    public boolean verificarCampoOcupado(int linha, int coluna, Matrix<Integer> tabuleiro){
        Integer valor = tabuleiro.obterElemento(linha, coluna);
        if (valor != null && valor != 0){
            return true;
        }
        return false;
    }
    
    public boolean verificarLinha(int linha, int valor, Matrix<Integer> tabuleiro){
        for(int coluna = 0; coluna < tabuleiro.matriz[0].length; coluna++){
            Integer val = tabuleiro.obterElemento(linha, coluna);
            if(val != null && val == valor){
                return true;
            }
        }
        return false;
    }


    public boolean verificarColuna(int coluna, int valor, Matrix<Integer> tabuleiro){
        for(int linha = 0; linha < tabuleiro.matriz.length; linha++){
            Integer val = tabuleiro.obterElemento(linha,coluna);
            if (val != null && val == valor){
                return true;

            }
        }
        return false;
    }


    /**
     * Verificar se o valor já existe no bloco regional (Bloco 3x3)
     * @Param linha, coluna, valor e o tabuleiro da classe genérica
     * @Return true ou false, se possui valor, ou não.
     * */
    public boolean verificarBlocoRegional(int linha, int coluna, int valor, Matrix<Integer> tabuleiro){
        int inicioLinha = (linha / 3) * 3;
        int inicioColuna = (coluna / 3) * 3;

        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                Integer val = tabuleiro.obterElemento(inicioLinha + i, inicioColuna + j);
                if (val != null && val == valor){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Método responsável por combinar todos os métodos acima em um só,
     * e testá-los se todas as condições forem atendidas.*/
    public boolean podeColocarNumero(int linha, int coluna, int valor, Matrix<Integer> tabuleiro){

        //Primeira verificação - Verificando se valor é maior que 1 e menor que 9
        if( valor < 1 || valor > 9){
            return false;
        }
        //Segunda verificação - Se o valor estiver certo, verificar se o campo nao está ocupado
        if (verificarCampoOcupado(linha, coluna, tabuleiro)){
            return false;
        }
        //Terceira verificação - Se o campo não estiver ocupado, verificar se a linha nao está ocupada
        if (verificarLinha(linha, valor, tabuleiro)){
            return false;
        }
        //Quarta verificação - Se o campo linha passar, verificar se a coluna nao está ocupada
        if (verificarColuna(coluna, valor, tabuleiro)){
            return false;
        }
        //Quinta verificação - Se o campo coluna passar, verificar o campo regional nao esta ocupado
        if (verificarBlocoRegional(linha,coluna,valor,tabuleiro)){
            return false;
        }

        //Se tudo passar, retornar TRUE
        return true;


    }

    // Coloca o número no campo informado, se tidas as regras passarem
    public void colocarNumero(int linha, int coluna, int valor, Matrix<Integer> tabuleiro){


        //Chamar o método booleano pra verificar se podemos adicionar valor no campo
        if(verificarCampoOcupado(linha, coluna, tabuleiro)){
            throw new JaTemValorNoCampoInformadoExc(
                    "Erro: Campo (" + linha + "," + coluna + ") já possui valor!"
            );
        }

        //Chamando o método acima, que faz todas as condições para verificação
        if(!podeColocarNumero(linha, coluna, valor, tabuleiro)){
            throw new JaTemValorNoCampoInformadoExc(
                    "Erro: Valor " + valor + " não pode ser colocado em (" + linha + "," + coluna + ") , pois já tem " +
                            " um valor lá"
            );
        }

        //Se tudo estiver correto e passar, adicionar elemento no array
        tabuleiro.adicionarElemento(linha, coluna, valor);
    }

}
