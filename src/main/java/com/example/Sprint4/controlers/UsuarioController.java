package com.example.Sprint4.controlers;

import com.example.Sprint4.entities.Usuario;
import com.example.Sprint4.services.UsuarioServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/Usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>{
    @GetMapping("/buscarUsuarioPorUserName")
    public ResponseEntity<?> findUsuarioByUsername(@RequestParam String username){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findUsuarioByUsername(username));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
