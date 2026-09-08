package dev.java10x.CadastroDeNinjas.Ninjas;

import jakarta.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boas-vindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adiciona ninja   (CREATE)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO){

        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Novo ninja criado com sucesso! ID: " + novoNinja.getId() + ", Nome: " + novoNinja.getNome());
    }

    // Mostrar todos os ninjas    (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // Mostrar ninja por ID  (READ)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){

        NinjaDTO ninjas =  ninjaService.listarNinjasPorId(id);
        if(ninjas != null){
            return ResponseEntity.ok(ninjas);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id: " + id + " não encontrado.");
        }
    }

    // Alterar dados dos ninja    (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjaPorId(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja =  ninjaService.atualizarNinja(id, ninjaAtualizado);

        if(ninja != null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com id: " + id + " não encontrado.");
        }
    }

    // Deletar ninja    (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
       if (ninjaService.listarNinjasPorId(id) != null){
           ninjaService.deletarNinjaPorId(id);
           return ResponseEntity.ok("Ninja com id: " + id + " deletado com sucesso!");
       }
       else {
              return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body("Ninja com id: " + id + " não encontrado.");
         }
    }
}
