package med.voll.api.pacientes;

public record DadosListagemPacientesDTO (String nome, String email, String cpf) {

    public DadosListagemPacientesDTO(PacienteEntity paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
