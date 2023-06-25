package br.com.alura.screenmatch.domain.filme;


// Para representar os dados que vem do formulario para colocar na classe cadastraFilme
public record DadosCadastroFilmes(String nome, Integer duracao, Integer ano, String genero) {}
