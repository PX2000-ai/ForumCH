package br.com.alura.ForumCH.controller;

import br.com.alura.ForumCH.dados.DadosUsuario;
import br.com.alura.ForumCH.repository.UsuarioRepository;
import br.com.alura.ForumCH.user.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    public void cadastro(@RequestBody DadosUsuario dados) {
        Usuario resposta = new Usuario(
                dados.nome(),
                dados.email(),
                dados.senha(),
                dados.perfil()
        );
        repository.save(resposta);
    }
}
