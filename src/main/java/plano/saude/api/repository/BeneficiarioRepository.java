package plano.saude.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import plano.saude.api.domain.Beneficiario;

import java.util.List;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {

    Page<Beneficiario> findAllByAtivoTrue(Pageable p);
}
