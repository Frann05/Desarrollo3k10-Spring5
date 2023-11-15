package com.example.Sprint4.services;

import com.example.Sprint4.entities.Usuario;
import com.example.Sprint4.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UsuarioServiceTest {
    @MockBean
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Test
    void testBuscarUsuarioPorUserName() throws Exception{
        Usuario usuario = new Usuario();
        usuario.setUsername("JuanPa");


        List<Usuario> listaEnviada = new ArrayList<>();
        listaEnviada.add(usuario);

        when(usuarioRepository.findUsuarioByUsername("JuanPa")).thenReturn(listaEnviada);

        assertEquals(listaEnviada, usuarioService.findUsuarioByUsername("JuanPa"));
    }
}
