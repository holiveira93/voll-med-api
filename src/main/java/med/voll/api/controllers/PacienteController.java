package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.pacientes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacienteRepository pacienteRepository;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid PacienteDTO pacienteDTO, UriComponentsBuilder uriBuilder){
        PacienteEntity paciente = new PacienteEntity(pacienteDTO);
        pacienteRepository.save(paciente);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }


    @GetMapping
    public ResponseEntity<Page<DadosListagemPacientesDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        var page = pacienteRepository.findAllByAtivoTrue(pageable).map(DadosListagemPacientesDTO::new);

        return ResponseEntity.ok(page);
    }


    @PutMapping()
    @Transactional
    public ResponseEntity atualizar(@RequestBody AtualizacaoPacienteDTO dto){
        var paciente = pacienteRepository.getReferenceById(dto.id());
        paciente.atualizar(dto);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id){
        pacienteRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity exclusaoLogica(@PathVariable Long id){
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.exclusaoLogica();

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var paciente = pacienteRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

}
