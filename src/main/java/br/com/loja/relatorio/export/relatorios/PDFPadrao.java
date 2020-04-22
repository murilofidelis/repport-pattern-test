package br.com.loja.relatorio.export.relatorios;

import br.com.loja.relatorio.exception.ImpressaoExeption;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import org.hamcrest.Matchers;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class PDFPadrao {

    protected String getHTML(String path) {

        InputStream resourceAsStream = Matchers.class.getResourceAsStream(path);

        try (Scanner scanner = new Scanner(resourceAsStream, StandardCharsets.UTF_8.name())) {
            return scanner.useDelimiter("\\A").next();
        } catch (RuntimeException e) {
            throw new ImpressaoExeption("Erro ao carregar template.");
        }
    }

    protected byte[] getBytesPdf(HashMap<String, String> valores, String html) {
        try {

            html = substituirValoresParametrizados(html, valores);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            List<IElement> elements = HtmlConverter.convertToElements(html);

            PdfWriter pdfWriter = new PdfWriter(outputStream);

            PdfDocument pdfDocument = new PdfDocument(pdfWriter);

            Document document = new Document(pdfDocument, PageSize.A4);

            document.setMargins(24F, 50F, 55F, 77F);

            for (IElement element : elements) {
                document.add((IBlockElement) element);
            }

            document.close();

            return outputStream.toByteArray();

        } catch (IOException e) {
            throw new ImpressaoExeption("Erro ao gerar PDF", e);
        }
    }

    private String substituirValoresParametrizados(String html, HashMap<String, String> valores) {
        for (Map.Entry<String, String> valorParametrizado : valores.entrySet()) {
            if (valorParametrizado.getValue() != null) {
                html = html.replace(valorParametrizado.getKey(), valorParametrizado.getValue());
            }
        }
        return html;
    }

    protected void setHeaderResponde(HttpServletResponse response, String nomeArquivo) {
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader("Content-Disposition", "attachment; filename=" + nomeArquivo);
    }

}
