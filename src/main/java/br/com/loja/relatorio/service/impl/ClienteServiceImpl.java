package br.com.loja.relatorio.service.impl;

import br.com.loja.relatorio.domain.Cliente;
import br.com.loja.relatorio.domain.mapper.ClienteMapper;
import br.com.loja.relatorio.repository.ClienteRepository;
import br.com.loja.relatorio.service.IClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteServiceImpl implements IClienteService {

    private final ClienteMapper mapper;
    private final ClienteRepository repository;

    public List<Cliente> getTodos() {
        return repository.findAll();
    }

    @Override
    public Object getDataExport() {
        return mapper.listDTO(this.getTodos());
    }
}
