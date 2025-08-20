package br.com.alura.ForumCH.dados;

import java.time.LocalDateTime;

public record DadosTopico(
        String titulo,
        String mensagem,
        LocalDateTime dataDeCriacao,
        String estadoDoTopico,
        Long cursoId
) {}
