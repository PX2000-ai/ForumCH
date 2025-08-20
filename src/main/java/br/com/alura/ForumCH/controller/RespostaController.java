package br.com.alura.ForumCH.controller;

import br.com.alura.ForumCH.dados.DadosResposta;
import br.com.alura.ForumCH.answer.Respostas;
import br.com.alura.ForumCH.repository.RespostaRepository;
import br.com.alura.ForumCH.repository.TopicoRepository;
import br.com.alura.ForumCH.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resposta")
public class RespostaController {

    @Autowired
    private RespostaRepository repository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public void cadastro(@RequestBody DadosResposta dados) {
        var topico = topicoRepository.findById(dados.topicoId())
                .orElseThrow(() -> new RuntimeException("Tópico não encontrado!"));

        var autor = usuarioRepository.findById(dados.autorId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        Respostas resposta = new Respostas(topico, dados.mensagem(), autor, dados.solucao());

        repository.save(resposta);
    }
}
