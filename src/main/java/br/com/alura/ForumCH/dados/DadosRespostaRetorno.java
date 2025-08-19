package br.com.alura.ForumCH.dados;

import br.com.alura.ForumCH.answer.Respostas;

import java.time.LocalDateTime;

public record DadosRespostaRetorno(
        Long id,
        String mensagem,
        LocalDateTime dataCriacao,
        String autor,
        boolean solucao
) {
    public DadosRespostaRetorno(Respostas resposta) {
        this(
                resposta.getId(),
                resposta.getMensagem(),
                resposta.getDataCriacao(),
                resposta.getAutor().getNome(), // supondo que Usuario tenha getNome()
                resposta.isSolucao()
        );
    }
}
