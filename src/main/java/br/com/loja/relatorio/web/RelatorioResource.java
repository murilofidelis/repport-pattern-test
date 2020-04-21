package br.com.loja.relatorio.web;

import br.com.loja.relatorio.enuns.Formato;
import br.com.loja.relatorio.enuns.TipoRelatorio;
import br.com.loja.relatorio.service.IRelatorioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("relatorio")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RelatorioResource {

    private final IRelatorioService service;

    @ResponseBody
    @GetMapping("/exporta")
    public void getRelatorio(@RequestParam("tipo") TipoRelatorio tipo, @RequestParam("formato") Formato formato, HttpServletResponse response) {
        log.info("getRelatorio");
        service.exporta(tipo, formato, response);
    }
}
