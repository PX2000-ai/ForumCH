package br.com.alura.ForumCH.dados;

import br.com.alura.ForumCH.Topico.Topico;
import br.com.alura.ForumCH.user.Usuario;

import java.time.LocalDateTime;

public record DadosResposta(Long topicoId, String mensagem, LocalDateTime dataCriacao, Long autorId, boolean solucao) {
}
