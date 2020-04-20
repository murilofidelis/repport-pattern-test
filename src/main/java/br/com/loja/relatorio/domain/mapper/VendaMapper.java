package br.com.loja.relatorio.domain.mapper;

import br.com.loja.relatorio.domain.Venda;
import br.com.loja.relatorio.domain.dto.VendaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VendaMapper extends AbstractMapper<Venda, VendaDTO> {

}
