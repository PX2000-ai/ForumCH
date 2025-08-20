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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;

    // Alinhando com o banco (data_criacao)
    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataDeCriacao;

    // Alinhando com o banco (status)
    @Column(name = "status", nullable = false)
    private String estadoDoTopico;

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Respostas> respostas = new ArrayList<>();

    public Topico(DadosTopico dados, Usuario autor, Curso curso) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataDeCriacao = dados.dataDeCriacao();
        this.estadoDoTopico = dados.estadoDoTopico();
        this.autor = autor;
        this.curso = curso;
    }
}


