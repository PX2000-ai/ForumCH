package br.com.alura.ForumCH.repository;

import br.com.alura.ForumCH.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}