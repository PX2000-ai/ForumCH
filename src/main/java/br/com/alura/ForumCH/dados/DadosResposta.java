package br.com.alura.ForumCH.dados;

public record DadosResposta(
        Long topicoId,
        String mensagem,
        Long autorId,
        boolean solucao
) {}
