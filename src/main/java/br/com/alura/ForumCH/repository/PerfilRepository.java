package br.com.alura.ForumCH.repository;

import br.com.alura.ForumCH.user.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}