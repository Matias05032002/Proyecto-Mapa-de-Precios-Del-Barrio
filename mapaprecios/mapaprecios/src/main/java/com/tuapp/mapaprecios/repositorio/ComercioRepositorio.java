package com.tuapp.mapaprecios.repositorio;

import com.tuapp.mapaprecios.modelo.Comercio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComercioRepositorio extends JpaRepository<Comercio, Long> {
}
