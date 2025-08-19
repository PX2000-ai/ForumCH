package br.com.alura.ForumCH.controller;

import br.com.alura.ForumCH.curso.Curso;
import br.com.alura.ForumCH.dados.DadosCurso;
import br.com.alura.ForumCH.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public Curso cadastrar(@RequestBody DadosCurso dados) {
        var curso = new Curso(dados);
        return cursoRepository.save(curso);
    }

    @GetMapping("/{id}")
    public Curso buscarPorId(@PathVariable Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado!"));
    }

    @GetMapping
    public Iterable<Curso> listarTodos() {
        return cursoRepository.findAll();
    }
}