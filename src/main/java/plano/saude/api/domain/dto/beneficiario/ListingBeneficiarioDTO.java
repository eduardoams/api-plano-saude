package plano.saude.api.domain.dto.beneficiario;

import plano.saude.api.domain.Beneficiario;

import java.util.Date;

public record ListingBeneficiarioDTO(String nome, String telefone, Date dataNascimento) {

    public ListingBeneficiarioDTO(Beneficiario b) {
        this(b.getNome(), b.getTelefone(), b.getDataNascimento());
    }
}
