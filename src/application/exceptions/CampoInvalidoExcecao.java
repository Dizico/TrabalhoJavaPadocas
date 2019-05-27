package application.exceptions;

import application.util.Utils;

public class CampoInvalidoExcecao extends RuntimeException {
    public CampoInvalidoExcecao(String message) {
        super(message);
        Utils.TelaErro(message);
    }
}
