package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.domain.filme.DadosAlteracaoFilmes;
import br.com.alura.screenmatch.domain.filme.DadosCadastroFilmes;
import br.com.alura.screenmatch.domain.filme.Filme;
import br.com.alura.screenmatch.domain.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller // Indica para o Spring que esta classe java é um controlador
@RequestMapping("/filmes") // Para acessar na url com /filmes chama esta classe

public class FilmeController { //Class Controller para receber requisições http

    @Autowired // Amarra depedencia para instanciar o objeto
    private FilmeRepository repository;

    @GetMapping("/formulario") //Quando chamado /filmes e tenha um GET com /formulario ele carrega o formulario
    public String carregaFormulario(Long id, Model model){
        if (id != null) {
            var filmes = repository.getReferenceById(id);
            model.addAttribute("filmes", filmes);
        }
        return "filmes/formulario";
    }

    @GetMapping //Quando chamado /filmes e tenha um GET ele carrega a listagem
    public String carregaListagem(Model model){
        model.addAttribute("lista", repository.findAll());
        return "filmes/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraFilme(DadosCadastroFilmes dados){ //Quando chamado /filmes e tenha um POST ele cadastra filmes que estão vindo do formulario
        var filme = new Filme(dados);
        repository.save(filme);
        return "redirect:/filmes";
    }

    @PutMapping
    @Transactional
    public String alteraFilme(DadosAlteracaoFilmes dados){
        var filmes = repository.getReferenceById(dados.id());
        filmes.atualizaDados(dados);
        return "redirect:/filmes";
    }

    @DeleteMapping
    @Transactional
    public String removeFilme(Long id){
        repository.deleteById(id);
        return "redirect:/filmes";
    }

}
