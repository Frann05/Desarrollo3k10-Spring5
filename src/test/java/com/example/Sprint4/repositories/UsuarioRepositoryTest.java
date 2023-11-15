package com.example.Sprint4.repositories;

import com.example.Sprint4.entities.Usuario;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UsuarioRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testBuscarUsuarioPorUsername() {
        Usuario usuario = new Usuario();
        usuario.setUsername("JuanPa");

        List<Usuario> listaEnviada = new ArrayList<>();
        listaEnviada.add(usuario);

        entityManager.persist(usuario);
        entityManager.flush();

        assertEquals(listaEnviada, usuarioRepository.findUsuarioByUsername("JuanPa"));

    }
}
