package com.marllon.vieira.vergili.sudoku.services;


/***
 * Classe Matrix (Matriz) - Essa classe, ja irá me ajudar a instanciar os arrays
 * necessários do Tabuleiro.
 *
 *
 * Essa classe, eu peguei, de um projeto que tinha realizado de estudo do curso
 * da Loiane Groner, de estrutura de dados em Java, quando estava aprendendo
 * Estrutura de dados, lá em meados de 2024. E ela ensinou todas as estruturas debaixo dos panos, as APIS.
 *
 * Aproveitei essa estrutura que estava no meu computador, que tinnha feito aquela época,
 * e resolvi utilizá-la neste projeto (Por que não?)
 * poderá me facilitar muito, só chamando os métodos depois..
 *
 * Essa classe de estrutura de dados está no meu reposítório GitHub.
 *@Link <a href="link">https://github.com/Marllon-Vieira-Vergili/Estrutura_dados_Loiane_Groner.git</a>
 *
 * CURSO: https://www.youtube.com/playlist?list=PLGxZ4Rq3BOBrgumpzz-l8kFMw2DLERdxi
 *
 *
 *
 * */



public class Matrix <T>{

    public Object[][] matriz;
    public int tamanho = 0;

    public Matrix(){
        this(5,5);
    }

    public Matrix(int linhas, int colunas){
        this.matriz = new Object[linhas][colunas];
    }

    public void adicionarELemento(int linha, int coluna, T elemento){

        validarIndices(linha, coluna);
        this.matriz[linha][coluna] = elemento;
        tamanho++;
    }

    public int retornarTamanho(){
        return this.tamanho;

    }

    public void preencherMatrizToda(T valor){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++){
                matriz[i][j] = valor;
            }
        }
    }

    public boolean estaVazia(){


        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++){
                if (matriz[i][j] == null){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean limparMatriz(){

        boolean matrizAlterada = false;
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++){
                if (matriz[i][j] != null){
                    matriz[i][j] = null;
                    matrizAlterada = true;
                }
            }
        }
        return matrizAlterada;
    }


    public T obterElemento(int linha, int coluna){
        validarIndices(linha, coluna);
        return (T) matriz[linha][coluna];
    }

    public void validarIndices(int linha, int coluna){
        if (linha < 0 || linha>= matriz.length || coluna < 0 || coluna >= matriz.length){
            throw new IndexOutOfBoundsException("Ìndices fora do limite da matriz!");
        }
    }

    @Override
    public String toString() {


        if (limparMatriz() == true){
            return "[][]";
        }
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){ //retorna o numero total de colunas na linha i
                builder.append(matriz[i][j] != null ? matriz[i][j].toString() : "0"); /*
               Aqui, o código verifica se o elemento na posição [i][j] da matriz é null.
Se não for null: Chama o método toString() do objeto armazenado na posição [i][j] e o adiciona à StringBuilder.
Se for null: Adiciona a palavra "Nulo" à StringBuilder. */

                if (j< matriz[i].length - 1){
                    builder.append("\t"); //separador de tabulação entre colunas
                }
            }
            builder.append("\n"); //quebra de linha entre as linhas da matriz

        }


        builder.append("]");
        return builder.toString();
    }

}
