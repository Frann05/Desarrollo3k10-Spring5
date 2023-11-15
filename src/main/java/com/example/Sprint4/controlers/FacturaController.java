package com.example.Sprint4.controlers;

import com.example.Sprint4.entities.Factura;
import com.example.Sprint4.services.FacturaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/Facturas")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl> {
    @PostMapping("/Facturar")
    public ResponseEntity FacturarPedido(@RequestParam Long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body("Factura Creada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));

        }
    }
}
