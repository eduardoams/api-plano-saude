package plano.saude.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import plano.saude.api.domain.Beneficiario;
import plano.saude.api.repository.BeneficiarioRepository;

import java.util.List;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository repository;

    public List<Beneficiario> findAll() {
        return repository.findAllByAtivoTrue();
    }
}
