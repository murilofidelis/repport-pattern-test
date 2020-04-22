package br.com.loja.relatorio.export;

import br.com.loja.relatorio.enuns.AppContext;
import br.com.loja.relatorio.enuns.Formato;
import br.com.loja.relatorio.enuns.TipoRelatorio;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@SuppressWarnings("unchecked")
public class Relatorio {

    private Formato formato;

    private TipoRelatorio tipo;

    private HttpServletResponse response;

    public static Relatorio builder() {
        return new Relatorio();
    }

    public Relatorio comResposta(HttpServletResponse response) {
        this.response = response;
        return this;
    }

    public Relatorio doTipo(TipoRelatorio tipo) {
        this.tipo = tipo;
        return this;
    }

    public Relatorio noFormato(Formato formato) {
        this.formato = formato;
        return this;
    }

    public void build() {
        this.montaRelatorio();
    }

    private void montaRelatorio() {
        Object dados = this.getDadosRelatorio();
        IRelatorioExport export = this.tipo.createInstance();
        export.exporta(dados, this.formato, this.response);
    }

    private Object getDadosRelatorio() {
        IRelatorioExportData service = AppContext.getInstance().getContext()
                .getBean((Class<IRelatorioExportData>) getClassProvide());
        return service.getDataExport();
    }

    private <T> T getClassProvide() {
        return (T) tipo.getService();
    }

}


