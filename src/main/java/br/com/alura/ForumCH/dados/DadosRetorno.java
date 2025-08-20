package br.com.alura.ForumCH.dados;

import java.time.LocalDateTime;
import java.util.List;

import br.com.alura.ForumCH.Topico.Topico;

public record DadosRetorno(Long id,
                           String titulo,
                           String mensagem,
                           LocalDateTime data_de_criacao,
                           String estado_do_topico,
                           String autor,
                           String curso,
                           List<DadosRespostaRetorno> respostas
)  {
    public DadosRetorno(Topico topico) {
            this(
                    topico.getId(),
                    topico.getTitulo(),
                    topico.getMensagem(),
                    topico.getDataDeCriacao(),
                    topico.getEstadoDoTopico(),
                    topico.getAutor().getNome(),
                    topico.getCurso().getNome(),
                    topico.getRespostas().stream().map(DadosRespostaRetorno::new).toList()
            );
    }
}

