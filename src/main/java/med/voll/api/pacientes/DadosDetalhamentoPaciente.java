package med.voll.api.pacientes;

import med.voll.api.endereco.Endereco;
import med.voll.api.medico.MedicoEntity;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String telefone,
                                        String cpf, Endereco endereco) {

    public DadosDetalhamentoPaciente(PacienteEntity paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(),
                paciente.getCpf(), paciente.getEndereco());
    }
}
