package br.com.alura.screenmatch.domain.filme;

import jakarta.persistence.*;

@Entity // Indica uma entidade ou seja la no banco de dados tem uma tabela representando está classe
@Table(name = "filmes") // Nome da tabela que existe dentro do Database

public class Filme {
    @Id // Identifica chave primaria da tabela filme
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia de geração de chaves no banco
    private Long id;
    private String nome;
    private String genero;
    private Integer duracao_em_minutos ;
    private Integer ano_lancamento ;

    public Filme(DadosCadastroFilmes dados){
        this.nome = dados.nome();
        this.duracao_em_minutos  = dados.duracao();
        this.ano_lancamento  = dados.ano();
        this.genero = dados.genero();
    }

    public Filme(){}

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", duracao=" + duracao_em_minutos  +
                ", ano=" + ano_lancamento  +
                '}';
    }



    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getDuracao() {
        return duracao_em_minutos ;
    }

    public Integer getAno() {
        return ano_lancamento ;
    }


    public void atualizaDados(DadosAlteracaoFilmes dados) {
        this.nome = dados.nome();
        this.duracao_em_minutos = dados.duracao();
        this.genero = dados.genero();
        this.ano_lancamento = dados.ano();
    }
}
