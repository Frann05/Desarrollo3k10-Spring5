package com.example.Sprint4.repositories;

import com.example.Sprint4.entities.ArticuloManufacturado;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ArticuloManufacturadoRepositoryTest {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository1;

    @Test
    @Disabled
    void testSearchString(){
        ArticuloManufacturado articuloManufacturado1 = new ArticuloManufacturado();
        articuloManufacturadoRepository1.busquedaPorDenominacion("Hamburguesa");
        List<ArticuloManufacturado> list = new ArrayList<>();
        list.add(articuloManufacturado1);
        entityManager.persist(articuloManufacturado1);
        entityManager.flush();

        assertEquals(list, articuloManufacturadoRepository1.busquedaPorDenominacion("Hamburguesa"));
    }
}
