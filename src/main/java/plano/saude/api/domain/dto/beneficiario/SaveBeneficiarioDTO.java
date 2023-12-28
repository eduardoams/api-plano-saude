package plano.saude.api.domain.dto.beneficiario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.util.Date;

public record SaveBeneficiarioDTO(
        @NotBlank(message = "{nome.notblank")
        String nome,
        @NotBlank(message = "{telefone.notblank")
        String telefone,
        @Past(message = "{dataNascimento.past")
        Date dataNascimento) {
}
