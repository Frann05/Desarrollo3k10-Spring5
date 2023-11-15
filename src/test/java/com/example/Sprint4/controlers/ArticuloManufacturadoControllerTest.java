package com.example.Sprint4.controlers;


import com.example.Sprint4.entities.ArticuloManufacturado;
import com.example.Sprint4.services.ArticuloManufacturadoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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


public class ArticuloManufacturadoControllerTest {
    @MockBean
    private ArticuloManufacturadoServiceImpl articuloManufacturadoService1;
    private MockMvc mockMvc;
    @Test
    void testSearchString() throws Exception {
        ArticuloManufacturado articuloManufacturado1 = new ArticuloManufacturado();
        articuloManufacturado1.setDenominacion("Hamburguesa");
        List<ArticuloManufacturado> list = new ArrayList<>();
        list.add(articuloManufacturado1);
        when(articuloManufacturadoService1.busquedaPorDenominacion("Hamburguesa")).thenReturn(list);

        mockMvc.perform(get("/api/v1/producto/searchDenominacion")
                        .param("filtro", "Hamburguesa")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]", is("Hamburguesa")));
    }
}
