package br.com.alura.ForumCH.repository;

import br.com.alura.ForumCH.Topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
}
