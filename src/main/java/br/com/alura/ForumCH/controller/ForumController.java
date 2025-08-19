package br.com.alura.ForumCH.controller;

import br.com.alura.ForumCH.Topico.Topico;
import br.com.alura.ForumCH.dados.DadosRetorno;
import br.com.alura.ForumCH.dados.DadosTopico;
import br.com.alura.ForumCH.repository.CursoRepository;
import br.com.alura.ForumCH.repository.TopicoRepository;
import br.com.alura.ForumCH.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@RestController
@RequestMapping("forum")
public class ForumController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void cadastro(@RequestBody DadosTopico dados, Authentication authentication) {
        var curso = cursoRepository.findById(dados.cursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!"));

        var emailUsuario = authentication.getName();
        var autor = usuarioRepository.findByEmail(emailUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        topicoRepository.save(new Topico(dados, autor, curso));
    }

    @GetMapping
    public List<DadosRetorno> listar() {
        return topicoRepository.findAll()
                .stream()
                .map(DadosRetorno::new)
                .toList();
    }

    @GetMapping("/{id}")
    public DadosRetorno detalhar(@PathVariable Long id) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado!"));
        return new DadosRetorno(topico);
    }

    @PutMapping("/{id}")
    public DadosRetorno atualizar(@PathVariable Long id, @RequestBody DadosTopico dados, Authentication authentication) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado!"));

        // Verifica se o usuário logado é o autor
        var emailUsuario = authentication.getName();
        if (!topico.getAutor().getEmail().equals(emailUsuario)) {
            throw new RuntimeException("Você não tem permissão para atualizar este tópico!");
        }

        var curso = cursoRepository.findById(dados.cursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!"));

        topico.setTitulo(dados.titulo());
        topico.setMensagem(dados.mensagem());
        topico.setData_de_criacao(dados.data_de_criacao());
        topico.setEstado_do_topico(dados.estado_do_topico());
        topico.setCurso(curso);

        topicoRepository.save(topico);

        return new DadosRetorno(topico);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id, Authentication authentication) {
        var topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado!"));

        // Verifica se o usuário logado é o autor
        var emailUsuario = authentication.getName();
        if (!topico.getAutor().getEmail().equals(emailUsuario)) {
            throw new RuntimeException("Você não tem permissão para deletar este tópico.");
        }

        if (!topico.getRespostas().isEmpty()) {
            throw new RuntimeException("Não é possível excluir um tópico que já possui respostas!");
        }

        topicoRepository.delete(topico);
    }
}