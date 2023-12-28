package plano.saude.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import plano.saude.api.domain.Beneficiario;
import plano.saude.api.domain.dto.beneficiario.DetailBeneficiarioDTO;
import plano.saude.api.domain.dto.beneficiario.ListingBeneficiarioDTO;
import plano.saude.api.domain.dto.beneficiario.SaveBeneficiarioDTO;
import plano.saude.api.domain.dto.beneficiario.UpdateBeneficiarioDTO;
import plano.saude.api.repository.BeneficiarioRepository;

import java.time.Instant;
import java.util.Optional;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository repository;

    public Page<ListingBeneficiarioDTO> findAll(Pageable p) {
        return repository.findAllByAtivoTrue(p).map(ListingBeneficiarioDTO::new);
    }

    public DetailBeneficiarioDTO detail(Long id) {
        Beneficiario beneficiario = findById(id);
        return new DetailBeneficiarioDTO(beneficiario);
    }

    public Beneficiario findById(Long id) {
        Optional<Beneficiario> obj = repository.findByIdAndAtivoTrue(id);
        return obj.orElseThrow(() -> new RuntimeException("a"));
    }

    public DetailBeneficiarioDTO save(SaveBeneficiarioDTO data) {
        Beneficiario beneficiario = new Beneficiario(data);
        return new DetailBeneficiarioDTO(repository.save(beneficiario));
    }

    public DetailBeneficiarioDTO update(Long id, UpdateBeneficiarioDTO data) {
        Beneficiario beneficiario = repository.getReferenceById(id);
        updateData(beneficiario, data);

        return new DetailBeneficiarioDTO(repository.save(beneficiario));
    }

    public void updateData(Beneficiario entity, UpdateBeneficiarioDTO data) {
        entity.setNome(data.nome());
        entity.setTelefone(data.telefone());
        entity.setDataAtualizacao(Instant.now());
    }
}
