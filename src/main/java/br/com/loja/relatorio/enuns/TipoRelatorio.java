package br.com.loja.relatorio.enuns;

import br.com.loja.relatorio.export.IRelatorioExport;
import br.com.loja.relatorio.export.relatorios.RelatorioCliente;
import br.com.loja.relatorio.export.relatorios.RelatorioVenda;
import br.com.loja.relatorio.service.IClienteService;
import br.com.loja.relatorio.service.IVendaService;

public enum TipoRelatorio {

    CLIENTE(IClienteService.class) {
        @Override
        public RelatorioCliente createInstance() {
            return new RelatorioCliente();
        }
    },

    VENDA(IVendaService.class) {
        @Override
        public RelatorioVenda createInstance() {
            return new RelatorioVenda();
        }
    };

    private Class<?> serviceProvide;

    public abstract IRelatorioExport createInstance();

    TipoRelatorio(Class<?> classe) {
        this.serviceProvide = classe;
    }

    public Class<?> getService() {
        return serviceProvide;
    }
}
