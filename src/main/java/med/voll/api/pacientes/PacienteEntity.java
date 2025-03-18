package med.voll.api.pacientes;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.endereco.Endereco;

@Table(name = "pacientes")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private Endereco endereco;

    private boolean ativo;


    public PacienteEntity(PacienteDTO pacienteDTO) {
        this.nome = pacienteDTO.nome();
        this.email = pacienteDTO.email();
        this.telefone = pacienteDTO.telefone();
        this.cpf = pacienteDTO.cpf();
        this.endereco = new Endereco(pacienteDTO.endereco());
        this.ativo = true;
    }

    public void atualizar(AtualizacaoPacienteDTO dto) {
        if(dto.nome() != null) this.nome = dto.nome();
        if(dto.telefone() != null) this.telefone = dto.telefone();
        if(dto.enderecoDTO() != null) endereco.atualizarInformacoes(dto.enderecoDTO());
    }

    public void exclusaoLogica() {
        this.ativo = false;
    }
}
