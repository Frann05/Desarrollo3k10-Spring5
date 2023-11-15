package com.example.Sprint4.services;

import com.example.Sprint4.entities.Factura;
import com.example.Sprint4.repositories.BaseRepository;
import com.example.Sprint4.repositories.FacturaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;

    public FacturaServiceImpl(BaseRepository<Factura, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    @Transactional
    public void FacturarPedido(Long id) throws Exception {
        try {
            //facturaRepository.FacturarPedido(id);
            Factura f = facturaRepository.FacturarPedido(id);

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
