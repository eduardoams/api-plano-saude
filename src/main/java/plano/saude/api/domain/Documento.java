package plano.saude.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import plano.saude.api.domain.dto.documento.SaveDocumentoDTO;
import plano.saude.api.domain.enums.TipoDocumentoEnum;

import java.time.Instant;

@Entity
@Table(name = "tb_documento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private Instant dataInclusao;
    private Instant dataAtualizacao;

    @Enumerated(EnumType.STRING)
    private TipoDocumentoEnum tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    @JsonIgnore
    private Beneficiario beneficiario;

    public Documento(SaveDocumentoDTO data) {
        descricao = data.descricao();
        tipoDocumento = data.tipoDocumento();
    }
}
