package com.example.Sprint4.repositories;

import com.example.Sprint4.entities.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsuarioRepository extends BaseRepository<Usuario, Long>{
    @Query(
            value = "SELECT * FROM usuario WHERE usuario.username LIKE %:filtro%",
            nativeQuery = true
    )
    List<Usuario> findUsuarioByUsername(@Param("filtro") String username);
}
