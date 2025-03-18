package med.voll.api.pacientes;

public record DadosListagemPacientesDTO (Long id, String nome, String email, String cpf) {

    public DadosListagemPacientesDTO(PacienteEntity paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
