package br.com.loja.relatorio.export.relatorios;

import br.com.loja.relatorio.domain.dto.VendaDTO;
import br.com.loja.relatorio.enuns.Formato;
import br.com.loja.relatorio.export.IRelatorioExport;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
public class RelatorioVenda implements IRelatorioExport {

    @Override
    @SuppressWarnings("unchecked")
    public void exporta(Object dados, Formato formato, HttpServletResponse response) {
        log.info("EXPORTANDO RelatorioVenda FORMARTO: {}", formato);
        List<VendaDTO> vendas = (List<VendaDTO>) dados;
        vendas.forEach(v -> log.info(v.toString()));
    }
}
