package plano.saude.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import plano.saude.api.domain.dto.beneficiario.SaveBeneficiarioDTO;
import plano.saude.api.domain.dto.documento.SaveDocumentoDTO;

import java.time.Instant;
import java.util.*;

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

    @OneToMany(mappedBy = "beneficiario", fetch = FetchType.LAZY)
    private Set<Documento> documentos = new HashSet<>();

    public Beneficiario(Long id, String nome, String telefone, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataInclusao = Instant.now();
        this.dataAtualizacao = Instant.now();
        this.ativo = true;
    }

    public Beneficiario(SaveBeneficiarioDTO data) {
        nome = data.nome();
        telefone = data.telefone();
        dataNascimento = data.dataNascimento();
        dataInclusao = Instant.now();
        dataAtualizacao = Instant.now();
        ativo = true;
        documentos.add(new Documento(data.documentos()));
    }
}
