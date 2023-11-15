package com.example.Sprint4.services;

import com.example.Sprint4.entities.ArticuloManufacturado;
import com.example.Sprint4.repositories.ArticuloManufacturadoRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DataJpaTest
public class ArticuloManufacturadoServiceTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Test
    void testSearchString(){
        ArticuloManufacturado articuloManufacturado1 = new ArticuloManufacturado();
        articuloManufacturado1.setDenominacion("Hamburguesa");
        List<ArticuloManufacturado> list = new ArrayList<>();
        list.add(articuloManufacturado1);
        entityManager.persist(articuloManufacturado1);
        entityManager.flush();

        assertEquals(list, articuloManufacturadoRepository.busquedaPorDenominacion("Hamburguesa"));
    }


}
