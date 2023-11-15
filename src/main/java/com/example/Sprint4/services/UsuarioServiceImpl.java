package com.example.Sprint4.services;

import com.example.Sprint4.entities.Usuario;
import com.example.Sprint4.repositories.BaseRepository;
import com.example.Sprint4.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    @Transactional
    public List<Usuario> findUsuarioByUsername(String filtro) throws Exception {
        try {
            List<Usuario> usuarios = usuarioRepository.findUsuarioByUsername(filtro);
            return usuarios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
