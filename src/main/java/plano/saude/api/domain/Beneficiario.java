package plano.saude.api.domain;

import jakarta.persistence.*;
import lombok.*;
import plano.saude.api.domain.dto.beneficiario.SaveBeneficiarioDTO;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "tb_beneficiario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private Date dataNascimento;
    private Instant dataInclusao;
    private Instant dataAtualizacao;
    private Boolean ativo;

    public Beneficiario(SaveBeneficiarioDTO data) {
        nome = data.nome();
        telefone = data.telefone();
        dataNascimento = data.dataNascimento();
        dataInclusao = Instant.now();
        dataAtualizacao = Instant.now();
        ativo = true;
    }
}
