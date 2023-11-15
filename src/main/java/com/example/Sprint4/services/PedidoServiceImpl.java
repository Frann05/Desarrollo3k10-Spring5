package com.example.Sprint4.services;

import com.example.Sprint4.DTO.MostrarPedidosDTO;
import com.example.Sprint4.DTO.MovimientosMonetariosDTO;
import com.example.Sprint4.DTO.PedidosDTO;
import com.example.Sprint4.controlers.BaseControllerImpl;
import com.example.Sprint4.entities.Pedido;
import com.example.Sprint4.repositories.BaseRepository;
import com.example.Sprint4.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido,Long> implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoServiceRepository) {
        super(baseRepository);
    }

    @Override
    public MovimientosMonetariosDTO MovimientoMonetario() throws Exception {
        try {
            MovimientosMonetariosDTO movimientos = pedidoRepository.MovimientoMonetario();
            return movimientos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public MovimientosMonetariosDTO MovimientoMonetarioFecha(Date filtro1, Date filtro2) throws Exception {
        try {
            try {
                MovimientosMonetariosDTO movimientos = this.pedidoRepository.MovimientoMonetarioFecha(filtro1, filtro2);
                return movimientos;
            } catch (Exception var4) {
                throw new Exception(var4.getMessage());
            }
        } catch (Throwable var5) {
            throw var5;
        }
    }

    @Override
    public List<Pedido> BusquedaPedidoPorEstado(String filtro) throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.BusquedaPedidoPorEstado(filtro);
            return pedidos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public List<Pedido> BusquedaPedidoAConfirmar() throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.BusquedaPedidoAConfirmar();
            return pedidos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Pedido> buscarPedidoEnDelivery() throws Exception {
        try {
            return pedidoRepository.buscarPedidoEnDelivery();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public PedidosDTO mostrarDetallePedido(Long id) throws Exception {
        try {
            return pedidoRepository.mostrarDetallePedido(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    public void actulizarEstadoEntregado(Long id) throws Exception {
        try {
            pedidoRepository.actulizarEstadoEntregado(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public MostrarPedidosDTO mostrarEstadoPedido(Long id) throws Exception {
        try {
            MostrarPedidosDTO pedido = pedidoRepository.mostrarEstadoPedido(id);
            return pedido;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void actulizarEstadoaconfirmar(Long idPedido) throws Exception {
        try {
            pedidoRepository.actulizarEstadoaconfirmar(idPedido);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
    @Override
    public List<Pedido> VerPedidosPorUsuario(Long idCliente) throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.VerPedidosPorUsuario(idCliente);
            return pedidos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}
