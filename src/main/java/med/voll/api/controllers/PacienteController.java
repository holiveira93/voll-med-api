package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.pacientes.DadosListagemPacientesDTO;
import med.voll.api.pacientes.PacienteDTO;
import med.voll.api.pacientes.PacienteEntity;
import med.voll.api.pacientes.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid PacienteDTO pacienteDTO){
        pacienteRepository.save(new PacienteEntity(pacienteDTO));
    }

    @GetMapping
    public Page<DadosListagemPacientesDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return pacienteRepository.findAll(pageable).map(DadosListagemPacientesDTO::new);
    }

}
