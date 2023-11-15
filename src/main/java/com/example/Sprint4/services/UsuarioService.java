package com.example.Sprint4.services;

import com.example.Sprint4.entities.Usuario;

import java.util.List;

public interface UsuarioService extends BaseService<Usuario, Long>{
    List<Usuario> findUsuarioByUsername(String filtro) throws Exception;
}
