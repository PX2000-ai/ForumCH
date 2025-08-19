package br.com.alura.ForumCH.repository;

import br.com.alura.ForumCH.answer.Respostas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespostaRepository extends JpaRepository<Respostas, Long> {
}