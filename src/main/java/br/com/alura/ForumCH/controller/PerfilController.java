package br.com.alura.ForumCH.controller;

import br.com.alura.ForumCH.repository.PerfilRepository;
import br.com.alura.ForumCH.user.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilRepository repository;

    // Criar um perfil
    @PostMapping
    public Perfil criar(@RequestBody Perfil perfil) {
        return repository.save(perfil);
    }

    // Listar todos os perfis
    @GetMapping
    public List<Perfil> listar() {
        return repository.findAll();
    }

    // Buscar perfil por id
    @GetMapping("/{id}")
    public Perfil buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
    }

    // Atualizar perfil
    @PutMapping("/{id}")
    public Perfil atualizar(@PathVariable Long id, @RequestBody Perfil perfil) {
        Perfil existente = repository.findById(id).orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
        existente.setNome(perfil.getNome());
        return repository.save(existente);
    }

    // Deletar perfil
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}