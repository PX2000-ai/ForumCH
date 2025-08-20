package br.com.alura.ForumCH.answer;

import br.com.alura.ForumCH.Topico.Topico;
import br.com.alura.ForumCH.user.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "respostas")
public class Respostas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "topico_id", nullable = false)
    private Topico topico;

    private String mensagem;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    private boolean solucao;


    public Respostas(Topico topico, String mensagem, Usuario autor, boolean solucao) {
        this.topico = topico;
        this.mensagem = mensagem;
        this.autor = autor;
        this.solucao = solucao;
    }
}
