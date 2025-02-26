package med.voll.api.controllers;

import med.voll.api.medico.CadastroMedicoDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @PostMapping
    public void cadastrarMedico (@RequestBody CadastroMedicoDTO dto){
        System.out.println(dto);
    }
}
