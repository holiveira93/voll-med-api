package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.AtualizacaoMedicoDTO;
import med.voll.api.pacientes.*;
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
        return pacienteRepository.findAllByAtivoTrue(pageable).map(DadosListagemPacientesDTO::new);
    }

    @PutMapping()
    @Transactional
    public void atualizar(@RequestBody AtualizacaoPacienteDTO dto){
        var paciente = pacienteRepository.getReferenceById(dto.id());
        paciente.atualizar(dto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        pacienteRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public void exclusaoLogica(@PathVariable Long id){
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.exclusaoLogica();
    }

}
