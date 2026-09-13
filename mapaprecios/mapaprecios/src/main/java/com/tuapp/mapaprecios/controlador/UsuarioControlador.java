package com.tuapp.mapaprecios.controlador;

import com.tuapp.mapaprecios.modelo.Usuario;
import com.tuapp.mapaprecios.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")

public class UsuarioControlador {
    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/{id}")
    public Optional<Usuario> buscarPorId(@PathVariable Long id){
        return usuarioServicio.buscarPorId(id);
    }
    @GetMapping("/email/{email}")
    public Optional<Usuario> buscarPorEmail(@PathVariable String email){
        return usuarioServicio.buscarPorEmail(email);
    }

    @PostMapping
    public Usuario guardarUsuario (@RequestBody Usuario usuario){
        return usuarioServicio.guardarUsuario(usuario);
    }



}
