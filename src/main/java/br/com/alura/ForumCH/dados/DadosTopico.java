package br.com.alura.ForumCH.dados;

import br.com.alura.ForumCH.user.Usuario;

import java.time.LocalDateTime;

public record DadosTopico(
        String titulo,
        String mensagem,
        LocalDateTime data_de_criacao,
        String estado_do_topico,
        Long cursoId
) {}
