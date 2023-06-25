package br.com.alura.screenmatch.domain.filme;

import org.springframework.data.jpa.repository.JpaRepository;

//Metodo para criar o CRUD extendendo de JpaRepository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
