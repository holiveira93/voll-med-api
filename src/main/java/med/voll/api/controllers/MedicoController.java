package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.CadastroMedicoDTO;
import med.voll.api.medico.DadosListagemMedicoDTO;
import med.voll.api.medico.MedicoEntity;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar (@RequestBody @Valid CadastroMedicoDTO dto){
        medicoRepository.save(new MedicoEntity(dto));
    }

    @GetMapping
    public Page<DadosListagemMedicoDTO> listar (@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return medicoRepository.findAll(paginacao).map(DadosListagemMedicoDTO::new);
    }
}
