package br.com.loja.relatorio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ImpressaoExeption extends RuntimeException {

    public ImpressaoExeption(String message) {
        super(message);
    }

    public ImpressaoExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
