package _daysofcode.demo.infra;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "super herois")
@Entity(name = "SuperHerois")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SuperHerois {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório!")
    @Column(nullable = false)
    private String nome;
    @NotBlank(message = "Poder é obrigatório!")
    @Column(nullable = false)
    private String poder;
    private String genero;
    private String classificacao;
    private String idade;
    @NotBlank(message = "País é obrigatório!")
    @Column(nullable = false)
    private String paisDeOrigem;
    private boolean ativo;

    public SuperHerois(DadosSuperHerois dados){
        this.nome=dados.nome();
        this.poder=dados.poder();
        this.genero=dados.genero();
        this.classificacao=dados.classificacao();
        this.idade=dados.idade();
        this.paisDeOrigem=dados.paisDeOrigem();
    }


    public void atualizarInformacoes(DadosAtualizacaoSuperHerois dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.poder() != null) {
            this.nome = dados.poder();
        }
        if (dados.genero() != null) {
            this.nome = dados.genero();
        }
        if (dados.classificacao() != null) {
            this.nome = dados.classificacao();
        }
        if (dados.idade() != null) {
            this.nome = dados.idade();
        }
        if (dados.paisDeOrigem() != null) {
            this.nome = dados.paisDeOrigem();
        }

    }
}
