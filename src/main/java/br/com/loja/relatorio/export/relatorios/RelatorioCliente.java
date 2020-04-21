package br.com.loja.relatorio.export.relatorios;

import br.com.loja.relatorio.domain.dto.ClienteDTO;
import br.com.loja.relatorio.enuns.Formato;
import br.com.loja.relatorio.exception.ImpressaoExeption;
import br.com.loja.relatorio.export.IRelatorioExport;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
public class RelatorioCliente implements IRelatorioExport {

    @Override

    public void exporta(Object dados, Formato formato, HttpServletResponse response) {
        log.info("EXPORTANDO RelatorioCliente FORMARTO: {}", formato);
        if (formato.equals(Formato.XLS)) {
            new FormatoXLS(dados, response);
        } else if (formato.equals(Formato.PDF)) {
            new FormatoPDF(dados, response);
        } else {
            throw new ImpressaoExeption("Formato não disponível para tipo de ralatório.");
        }
    }
}

@Slf4j
@SuppressWarnings("unchecked")
class FormatoXLS extends XLSPadrao {

    private List<ClienteDTO> clientes;

    private HttpServletResponse response;

    private static final String NOME_ARQUIVO = "clientes.xlsx";

    private static final int LINHA_INICIAL = BigDecimal.ZERO.intValue();

    public FormatoXLS(Object dados, HttpServletResponse response) {
        this.clientes = (List<ClienteDTO>) dados;
        this.response = response;
        this.motaRelatorio();
    }

    private void motaRelatorio() {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DADOS");
            String[] colunas = {"ID", "Nome"};
            Row linhaCabecalho = sheet.createRow(LINHA_INICIAL);
            montaCabecalho(colunas, linhaCabecalho);
            int linhaInicialDadosRelatorio = (LINHA_INICIAL + 1);
            this.montaCorpoRelatorio(sheet, linhaInicialDadosRelatorio);
            organizaTamanhoColunas(sheet, colunas.length);
            setHeaderResponde(response, NOME_ARQUIVO);
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            log.error("Erro ao gerar arquivo: {}", e.getMessage());
            throw new ImpressaoExeption("Erro ao exportar relatório.");
        }
    }

    private void montaCorpoRelatorio(Sheet sheet, int linhaInicialDadosRelatorio) {
        for (ClienteDTO cliente : clientes) {
            Row linha = sheet.createRow(linhaInicialDadosRelatorio++);
            linha.createCell(BigDecimal.ZERO.intValue()).setCellValue(cliente.getId());
            linha.createCell(BigDecimal.ONE.intValue()).setCellValue(cliente.getNome());
        }
    }

}

@Slf4j
@SuppressWarnings("unchecked")
class FormatoPDF extends PDFPadrao {

    private List<ClienteDTO> clientes;

    private HttpServletResponse response;

    public FormatoPDF(Object dados, HttpServletResponse response) {
        this.clientes = (List<ClienteDTO>) dados;
        this.response = response;
        this.motaRelatorio();
    }

    private void motaRelatorio() {

    }
}