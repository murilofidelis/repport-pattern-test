package br.com.loja.relatorio.service.impl;

import br.com.loja.relatorio.domain.Venda;
import br.com.loja.relatorio.domain.mapper.VendaMapper;
import br.com.loja.relatorio.repository.VendaRepository;
import br.com.loja.relatorio.service.IVendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VendaServiceImpl implements IVendaService {

    private final VendaMapper mapper;
    private final VendaRepository repository;

    public List<Venda> getTodos() {
        return repository.findAll();
    }

    @Override
    public Object getDadosImpressao() {
        return this.mapper.listDTO(this.getTodos());
    }
}
