package med.voll.api.medico;

import med.voll.api.endereco.EnderecoDTO;

public record CadastroMedicoDTO(String nome, String email, String crm, Especialidade especialidade, EnderecoDTO endereco) {
}
