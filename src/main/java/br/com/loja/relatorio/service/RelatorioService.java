package br.com.loja.relatorio.service;

import br.com.loja.relatorio.enuns.Formato;
import br.com.loja.relatorio.enuns.TipoRelatorio;

import javax.servlet.http.HttpServletResponse;

public interface RelatorioService {

    void exporta(TipoRelatorio tipo, Formato formato, HttpServletResponse response);

}
