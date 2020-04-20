package br.com.loja.relatorio.impressao;

import br.com.loja.relatorio.enuns.Formato;

import javax.servlet.http.HttpServletResponse;

public interface RelatorioExport {

    void exporta(Object dados, Formato formato, HttpServletResponse response);

}
