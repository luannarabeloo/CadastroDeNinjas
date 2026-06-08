package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeDaMissao;
    private String dificuldade;

    //@OneToMany uma missao pode ter varios ninjas, ou seja, uma lista de ninjas
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjasPorMissao;


    public String getNomeDaMissao() {
        return nomeDaMissao;
    }

    public void setNomeDaMissao(String nomeDaMissao) {
        this.nomeDaMissao = nomeDaMissao;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    public MissoesModel(String nomeDaMissao, String dificuldade) {
        this.nomeDaMissao = nomeDaMissao;
        this.dificuldade = dificuldade;
    }

    public MissoesModel() {
    }
}
