package br.com.loja.relatorio.impressao.relatorios;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;

@Slf4j
public abstract class XLSPadrao {

    protected void setHeaderResponde(HttpServletResponse response, String nomeArquivo) {
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
        response.setHeader("Content-Disposition", "attachment; filename=" + nomeArquivo);
    }

    protected void montaCabecalho(String[] colunas, Row linhaCabecalho) {
        for (int i = 0; i < colunas.length; i++) {
            Cell cell = linhaCabecalho.createCell(i);
            cell.setCellValue(colunas[i]);
        }
    }

    protected void organizaTamanhoColunas(Sheet sheet, int quntidadeColunas) {
        try {
            for (int i = 0; i < quntidadeColunas; i++) {
                sheet.autoSizeColumn(i);
            }
        } catch (RuntimeException e) {
            log.error("ERRO, verifique se os pacotes de fontes estão instalados: {}", e.getMessage());
        }
    }
}
