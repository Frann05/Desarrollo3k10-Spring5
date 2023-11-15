package com.example.Sprint4.repositories;

import com.example.Sprint4.DTO.MostrarPedidosDTO;
import com.example.Sprint4.DTO.MovimientosMonetariosDTO;
import com.example.Sprint4.DTO.PedidosDTO;
import com.example.Sprint4.entities.Pedido;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

public interface PedidoRepository extends BaseRepository<Pedido, Long> {
    @Query(
            value = "SELECT " +
                    "SUM(total) AS total_ingresos, " +
                    "SUM(totalCosto) AS total_costos, " +
                    "SUM(total - totalCosto) AS diferencia " +
                    "FROM pedido",
            nativeQuery = true
    )
    MovimientosMonetariosDTO MovimientoMonetario();

    @Query(
            value = "SELECT " +
                    "SUM(TOTAL) AS total_ingresos, " +
                    "SUM(TOTAL_COSTO) AS total_costos, " +
                    "SUM(TOTAL - TOTAL_COSTO) AS diferencia " +
                    "FROM pedido p " +
                    "WHERE :filtro1 < p.FECHA_PEDIDO AND p.FECHA_PEDIDO < :filtro2",
            nativeQuery = true
    )
    MovimientosMonetariosDTO MovimientoMonetarioFecha(@Param("filtro1") Date filtro1, @Param("filtro2") Date filtro2);

    @Query(
            value = "SELECT * FROM pedido WHERE pedido.estado LIKE %:filtro%",
            nativeQuery = true
    )
    List<Pedido> BusquedaPedidoPorEstado(@Param("filtro") String filtro);


    @Query(
            value = "SELECT * FROM pedido WHERE pedido.estado = 'A_CONFIRMAR'  ",
            nativeQuery = true
    )
    List<Pedido> BusquedaPedidoAConfirmar();

    @Query(
            value = "SELECT * FROM pedido WHERE pedido.estado = 'PENDIENTE_ENTREGA'",
            nativeQuery = true
    )
    List<Pedido> buscarPedidoEnDelivery();

    @Query(
            value = "SELECT c.nombre AS nombreCli, c.apellido AS apellidoCli, c.telefono AS telefonoCli, d.calle AS calleDomicilio, d.numero AS nroDomicilio, d.localidad AS localidadDomicilio " +
                    "FROM pedido p " +
                    "INNER JOIN cliente c ON c.id = p.id_cliente " +
                    "INNER JOIN domicilio d ON d.id = p.id_domicilio_entrega " +
                    "WHERE p.id = :id",
            nativeQuery = true
    )
    PedidosDTO mostrarDetallePedido(@RequestParam("id") Long id);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE pedido SET pedido.estado = 'COMPLETADO' WHERE pedido.id = :id",
            nativeQuery = true
    )
    void actulizarEstadoEntregado(@Param("id") Long id);

    //Mostrar pedido al cliente con el tiempo de espera

    @Query(
            value = "SELECT " +
                    "MAX(am.tiempo_estimado_cocina) AS tiempo_maximo_articulo, " +
                    "IFNULL(MAX(tiempo_maximo_articulo), 0) AS tiempo_maximo_pedido_en_cocina, " +
                    "CASE " +
                    "WHEN pedido.TIPO_ENVIO = DELIVERY THEN 10 " +
                    "ELSE 0 " +
                    "END AS tiempo_entrega_delivery " +
                    "FROM " +
                    "detalle_pedido AS dp " +
                    "JOIN articulo_manufacturado AS am ON dp.id_articulo_manufacturado = am.id " +
                    "LEFT JOIN ( " +
                    "SELECT  MAX(tiempo_estimado_cocina) AS tiempo_estimado_pedido_en_cocina " +
                    "FROM detalle_pedido " +
                    "WHERE PEDIDO.ESTADO = PREPARACION " +
                    "GROUP BY pedido.id " +
                    ") AS pedidos_en_cocina ON dp.id_pedido = pedidos_en_cocina.id " +
                    "WHERE dp.id_pedido = :id",
            nativeQuery = true
    )
    MostrarPedidosDTO mostrarEstadoPedido(@Param("id") Long id);

    @Modifying
    @org.springframework.transaction.annotation.Transactional
    @Query(
            value = "UPDATE pedido SET pedido.estado = 'A_CONFIRMAR' WHERE pedido.id = :idPedido",
            nativeQuery = true
    )
    void actulizarEstadoaconfirmar(@Param("idPedido") Long idPedido);

    @Query(
            value = "SELECT * FROM pedido WHERE pedido.id_cliente = :idCliente ",
            nativeQuery = true
    )
    List<Pedido> VerPedidosPorUsuario(@Param("idCliente") Long idCliente);




}
