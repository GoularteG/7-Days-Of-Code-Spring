package _daysofcode.demo.infra;

public record DadosListagemSuperHerois( Long id,
                                        String nome,
                                        String poder,
                                        String genero,
                                        String classificacao,
                                        String idade,
                                        String paisDeOrigem) {

    public DadosListagemSuperHerois(SuperHerois superHerois){
        this(superHerois.getId(),superHerois.getNome(),superHerois.getPoder(), superHerois.getClassificacao(),
                superHerois.getIdade(), superHerois.getGenero(), superHerois.getPaisDeOrigem());
    }
}
