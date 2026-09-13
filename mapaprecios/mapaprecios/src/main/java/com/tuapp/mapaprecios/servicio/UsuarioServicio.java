package com.tuapp.mapaprecios.servicio;

import com.tuapp.mapaprecios.modelo.Usuario;
import com.tuapp.mapaprecios.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepositorio.save(usuario);

    }

        public Optional<Usuario> buscarPorEmail(String email) {
            return usuarioRepositorio.findByEmail(email);
        }
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepositorio.findById(id);
    }
    }
