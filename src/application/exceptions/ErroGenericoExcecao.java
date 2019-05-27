package application.exceptions;

import application.util.Utils;

public class ErroGenericoExcecao extends RuntimeException{
    public ErroGenericoExcecao(String message, Integer number) {
        super(message);
        Utils.TelaErro("Erro Genérico: Número "+number);
    }
}
