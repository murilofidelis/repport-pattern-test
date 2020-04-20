package br.com.loja.relatorio.enuns;

import br.com.loja.relatorio.impressao.RelatorioExport;
import br.com.loja.relatorio.impressao.relatorios.RelatorioCliente;
import br.com.loja.relatorio.impressao.relatorios.RelatorioVenda;
import br.com.loja.relatorio.service.ClienteService;
import br.com.loja.relatorio.service.VendaService;

public enum TipoRelatorio {

    CLIENTE(ClienteService.class) {
        @Override
        public RelatorioCliente createInstance() {
            return new RelatorioCliente();
        }
    },

    VENDA(VendaService.class) {
        @Override
        public RelatorioVenda createInstance() {
            return new RelatorioVenda();
        }
    };

    private Class<?> serviceProvide;

    public abstract RelatorioExport createInstance();

    TipoRelatorio(Class<?> classe) {
        this.serviceProvide = classe;
    }

    public Class<?> getService() {
        return serviceProvide;
    }
}
