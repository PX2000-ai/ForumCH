package br.com.alura.ForumCH.dados;

import br.com.alura.ForumCH.user.Perfil;

import java.util.Set;

public record DadosUsuario(String nome, String email, String senha, Perfil perfil) {
}
