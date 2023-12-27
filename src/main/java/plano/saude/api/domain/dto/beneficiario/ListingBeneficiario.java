package plano.saude.api.domain.dto.beneficiario;

import plano.saude.api.domain.Beneficiario;

import java.util.Date;

public record ListingBeneficiario(String nome, String telefone, Date dataNascimento) {

    public ListingBeneficiario(Beneficiario beneficiario) {
        this(beneficiario.getNome(), beneficiario.getTelefone(), beneficiario.getDataNascimento());
    }
}
