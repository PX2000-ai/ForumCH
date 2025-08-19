package br.com.alura.ForumCH.Topico;

import br.com.alura.ForumCH.answer.Respostas;
import br.com.alura.ForumCH.curso.Curso;
import br.com.alura.ForumCH.dados.DadosTopico;
import br.com.alura.ForumCH.user.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime data_de_criacao;
    private String estado_do_topico;
    @ManyToOne
    @JoinColumn(name = "usuarios_id", nullable = false)
    private Usuario autor;
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false) // cria chave estrangeira no banco
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Respostas> respostas = new ArrayList<>();

    public Topico(DadosTopico dados, Usuario autor, Curso curso) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data_de_criacao = dados.data_de_criacao();
        this.estado_do_topico = dados.estado_do_topico();
        this.autor =autor;
        this.curso =curso;
    }
}

