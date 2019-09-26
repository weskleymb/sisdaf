package br.gov.rn.pm.sisdaf.service;

import br.gov.rn.pm.sisdaf.model.Policial;
import br.gov.rn.pm.sisdaf.repository.PolicialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicialService {

    @Autowired
    private PolicialRepository repository;

    public List<Policial> buscaTodos() {
        return repository.findAll();
    }

    public Policial buscaPorId(Long id) {
        return repository.findById(id).get();
    }

    public Policial salva(Policial policial) {
        policial.setNome(policial.getNome().toUpperCase().trim());
        return repository.save(policial);
    }

    public void removePorId(Long id) {
        repository.deleteById(id);
    }

}
