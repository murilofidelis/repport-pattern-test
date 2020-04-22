package br.com.loja.relatorio.export;

import br.com.loja.relatorio.enuns.Formato;

import javax.servlet.http.HttpServletResponse;

public interface IRelatorioExport {

    void exporta(Object dados, Formato formato, HttpServletResponse response);


}
