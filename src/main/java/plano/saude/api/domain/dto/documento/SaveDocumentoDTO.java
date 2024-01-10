package plano.saude.api.domain.dto.documento;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import plano.saude.api.domain.enums.TipoDocumentoEnum;

public record SaveDocumentoDTO(
        @NotBlank(message = "{descricao.notblank}")
        String descricao,
        @NotNull(message = "{tipoDocumento.notnull}")
        TipoDocumentoEnum tipoDocumento) {
}
