package med.voll.api.domain.pacientes;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.EnderecoDTO;

public record AtualizacaoPacienteDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoDTO enderecoDTO) {
}
