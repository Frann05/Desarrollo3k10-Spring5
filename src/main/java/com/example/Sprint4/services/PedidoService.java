package com.example.Sprint4.services;

import com.example.Sprint4.DTO.MostrarPedidosDTO;
import com.example.Sprint4.DTO.MovimientosMonetariosDTO;
import com.example.Sprint4.DTO.PedidosDTO;
import com.example.Sprint4.entities.Pedido;

import java.util.Date;
import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{
    List<Pedido> BusquedaPedidoPorEstado(String filtro) throws Exception;
    List<Pedido> BusquedaPedidoAConfirmar() throws Exception;

    MovimientosMonetariosDTO MovimientoMonetario() throws Exception;

    MovimientosMonetariosDTO MovimientoMonetarioFecha(Date filtro1, Date filtro2) throws Exception;

    List<Pedido> buscarPedidoEnDelivery() throws Exception;

    PedidosDTO mostrarDetallePedido(Long id) throws Exception;
    void actulizarEstadoEntregado(Long id) throws Exception;
    MostrarPedidosDTO mostrarEstadoPedido(Long id) throws Exception;

    public void actulizarEstadoaconfirmar(Long idPedido) throws Exception;
    List<Pedido> VerPedidosPorUsuario(Long idCliente) throws Exception;

}
