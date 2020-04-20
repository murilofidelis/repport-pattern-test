package br.com.loja.relatorio.service.impl;

import br.com.loja.relatorio.enuns.Formato;
import br.com.loja.relatorio.enuns.TipoRelatorio;
import br.com.loja.relatorio.impressao.Relatorio;
import br.com.loja.relatorio.service.RelatorioService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class RelatorioServiceImpl implements RelatorioService {

    public void exporta(TipoRelatorio tipo, Formato formato, HttpServletResponse response) {

        new Relatorio()
                .doTipo(tipo)
                .noFormato(formato)
                .comResposta(response)
                .exporta();

    }
}
