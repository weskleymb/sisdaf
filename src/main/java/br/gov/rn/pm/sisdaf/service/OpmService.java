package br.gov.rn.pm.sisdaf.service;

import br.gov.rn.pm.sisdaf.model.Opm;
import br.gov.rn.pm.sisdaf.repository.OpmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpmService {

    @Autowired
    private OpmRepository repository;

    public List<Opm> buscaTodos() {
        return repository.findAll();
    }

    public Opm buscaPorId(Long id) {
        return repository.findById(id).get();
    }

    public Opm salva(Opm opm) {
        opm.setNome(opm.getNome().toUpperCase().trim());
        opm.setSigla(opm.getSigla().toUpperCase().trim());
        return repository.save(opm);
    }

    public void removePorId(Long id) {
        repository.deleteById(id);
    }

}
