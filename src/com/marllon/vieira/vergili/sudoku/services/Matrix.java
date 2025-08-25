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

    public void adicionarElemento(int linha, int coluna, T elemento){

        validarIndices(linha, coluna);
        this.matriz[linha][coluna] = elemento;
        tamanho++;
    }

    public int retornarTamanho(){
        return this.tamanho;

    }

    public void preencherMatrizToda(T valor){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
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

    /**
     * Ajuste na classe toString para
     * renderizar o tabuleiro no console, tudo com
     * valores 0 "padrao"
     *
     * */
    @Override
    public String toString() {

        //variável receberá uma string vazia
        String resultado = "";

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {

                // Se a célula estiver nula, mostra 0
                if (matriz[i][j] == null) {
                    resultado += "0";
                } else { //Senão... a variável resultado vai mostrar o valor em forma de String
                    resultado += matriz[i][j].toString();
                }

                // Adicionar uma tabulação entre os números, exceto no final da linha
                if (j < matriz[i].length - 1) {
                    resultado += "\t";
                }
            }
            // Quebra de linha após cada linha da matriz
            resultado += "\n";
        }

        return resultado;
}
}
