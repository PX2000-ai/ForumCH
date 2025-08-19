package br.com.alura.ForumCH.controller;

import br.com.alura.ForumCH.dados.DadosLogin;
import br.com.alura.ForumCH.repository.PerfilRepository;
import br.com.alura.ForumCH.security.JwtService;
import br.com.alura.ForumCH.user.Perfil;
import br.com.alura.ForumCH.user.Usuario;
import br.com.alura.ForumCH.repository.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final PerfilRepository perfilRepository;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService,
                          UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder,
                          PerfilRepository perfilRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.perfilRepository = perfilRepository;
    }

    @PostMapping("/register")
    public String register(@RequestBody Usuario usuario) {
        // Criptografa a senha
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        // Se não houver perfil definido, atribui o perfil padrão (ID=1)
        if (usuario.getPerfil() == null) {
            Perfil perfilPadrao = perfilRepository.findById(1L)
                    .orElseThrow(() -> new RuntimeException("Perfil padrão não encontrado"));
            usuario.setPerfil(perfilPadrao);
        }

        usuarioRepository.save(usuario);
        return "Usuário registrado com sucesso!";
    }

    @PostMapping("/login")
    public String login(@RequestBody DadosLogin request) {
        // Autenticação
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.senha())
        );

        // Gera JWT
        return jwtService.generateToken(request.email());
    }
}