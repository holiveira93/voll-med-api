package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.pacientes.PacienteDTO;
import med.voll.api.pacientes.PacienteEntity;
import med.voll.api.pacientes.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @PostMapping()
    public void cadastrarPaciente(@RequestBody @Valid PacienteDTO pacienteDTO){
        pacienteRepository.save(new PacienteEntity(pacienteDTO));
    }
}
