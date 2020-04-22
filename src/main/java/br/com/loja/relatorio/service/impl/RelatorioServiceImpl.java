package br.com.loja.relatorio.service.impl;

import br.com.loja.relatorio.enuns.Formato;
import br.com.loja.relatorio.enuns.TipoRelatorio;
import br.com.loja.relatorio.export.Relatorio;
import br.com.loja.relatorio.service.IRelatorioService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class RelatorioServiceImpl implements IRelatorioService {

    public void exporta(TipoRelatorio tipo, Formato formato, HttpServletResponse response) {

         Relatorio.builder()
                .doTipo(tipo)
                .noFormato(formato)
                .comResposta(response)
                .build();
    }
}
