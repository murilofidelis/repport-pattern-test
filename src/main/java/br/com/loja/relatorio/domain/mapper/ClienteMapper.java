package br.com.loja.relatorio.domain.mapper;

import br.com.loja.relatorio.domain.Cliente;
import br.com.loja.relatorio.domain.dto.ClienteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends AbstractMapper<Cliente, ClienteDTO> {
}
