package dev.java10x.CadastroDeNinjas.Missoes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/missoes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissaoController {
    private MissoesService missoesService;

    //Rota para criar uma missao
    @PutMapping("/criar")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoes){
        return missoesService.criarMissao(missoes);
    }

    //Rota pra listar todas as missoes
    @GetMapping("/listar")
    public String listarMissoes() {
        return "Listar todas as missoes";
    }
    //Rota para listar missao por ID
    @GetMapping("/listar/{id}")
    public String listarMissaoPorId(){
        return "Listar missao por ID";
    }

    //Rota para deletar missao por ID

    //Rota para alterar missao por ID

}
