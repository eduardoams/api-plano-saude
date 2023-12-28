package plano.saude.api.domain.dto.beneficiario;

import plano.saude.api.domain.Beneficiario;

import java.time.Instant;
import java.util.Date;

public record DetailBeneficiarioDTO(Long id, String nome, String telefone, Date dataNascimento, Instant dataInclusao, Instant dataAtualizacao) {

    public DetailBeneficiarioDTO(Beneficiario b) {
        this(b.getId(), b.getNome(), b.getTelefone(), b.getDataNascimento(), b.getDataInclusao(), b.getDataAtualizacao());
    }
}
