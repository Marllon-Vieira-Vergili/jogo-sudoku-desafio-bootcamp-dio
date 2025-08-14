package com.marllon.vieira.vergili.sudoku.exceptions;


/**
 * Exception com mensagem customizada que o campo
 * que o usuário inserir o valor, ja está
 * preenchido, caso ele tente inserir valor
 * */
public class JaTemValorNoCampoInformadoExc extends RuntimeException {
    public JaTemValorNoCampoInformadoExc(String message) {
        super(message);
    }
}
