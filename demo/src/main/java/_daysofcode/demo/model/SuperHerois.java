package _daysofcode.demo.model;


import jakarta.persistence.*;
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


    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String poder;
    private String genero;
    @Column(nullable = false)
    private String classificacao;
    private String idade;
    private String paisDeOrigem;



}
