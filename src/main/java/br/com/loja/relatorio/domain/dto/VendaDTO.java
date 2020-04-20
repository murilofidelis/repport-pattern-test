package br.com.loja.relatorio.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class VendaDTO {

    private Long id;

    private String desProduto;

    private String marca;

    private BigDecimal preco;

    private Integer quantidade;

}
