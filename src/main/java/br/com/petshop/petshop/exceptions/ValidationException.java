package br.com.petshop.petshop.exceptions;

public class ValidationException extends RuntimeException{
    public ValidationException(String mensagem) {
        super(mensagem);
    }
}
