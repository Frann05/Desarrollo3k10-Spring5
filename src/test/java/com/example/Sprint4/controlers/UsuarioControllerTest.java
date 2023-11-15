package com.example.Sprint4.controlers;

import com.example.Sprint4.entities.Usuario;
import com.example.Sprint4.services.UsuarioServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(UsuarioControllerTest.class)
public class UsuarioControllerTest {

    @MockBean
    private UsuarioServiceImpl usuarioService;


    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFindUsuarioByUsername() throws Exception{
        Usuario usuario = new Usuario();
        usuario.setUsername("JuanPa");


        List<Usuario> listaEnviada = new ArrayList<>();
        listaEnviada.add(usuario);

        when(usuarioService.findUsuarioByUsername("JuanPa")).thenReturn(listaEnviada);

        mockMvc.perform(get("/api/v1/usuarios/buscarUsuarioPorUserName")
                        .param("filtro", "JuanPa")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].asusername", is("JuanPa")));
    }

}
