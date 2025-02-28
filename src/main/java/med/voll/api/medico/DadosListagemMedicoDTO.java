package med.voll.api.medico;

public record DadosListagemMedicoDTO(String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedicoDTO(MedicoEntity medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
