package med.voll.api.endereco;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    String logradouro;
    String bairro;
    String cep;
    String cidade;
    String uf;
    String numero;
    String complemento;

    public Endereco(EnderecoDTO endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
    }

    public void atualizarInformacoes(EnderecoDTO enderecoDTO) {
        if(enderecoDTO.logradouro() != null) this.logradouro = enderecoDTO.logradouro();
        if(enderecoDTO.bairro() != null) this.bairro = enderecoDTO.bairro();
        if(enderecoDTO.cep() != null) this.cep = enderecoDTO.cep();
        if(enderecoDTO.uf() != null) this.uf = enderecoDTO.uf();
        if(enderecoDTO.numero() != null) this.numero = enderecoDTO.numero();
        if(enderecoDTO.complemento() != null) this.complemento = enderecoDTO.complemento();
    }
}
