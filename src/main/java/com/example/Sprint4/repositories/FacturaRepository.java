package com.example.Sprint4.repositories;

import com.example.Sprint4.entities.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FacturaRepository extends BaseRepository<Factura, Long>{
    @Query(
            value = "INSERT INTO Factura (ID_PEDIDO, FECHA_FACTURACION, TOTAL_VENTA) "+
                    "SELECT "+
                    "ID AS ID_PEDIDO, "+
                    "CURRENT_DATE AS FECHA_FACTURACION, "+
                    "Total AS TOTAL_VENTA "+
                    "FROM pedido "+
                    "WHERE ID =:id AND Estado = 'PAGADO'; "+

                    "INSERT INTO Detalle_Factura (ID_Factura, ID_ARTICULO_MANUFACTURADO, Cantidad, SUBTOTAL) "+
                    "SELECT ID FROM FACTURA AS ID_FACTURA, "+
                    "ID_ARTICULO_MANUFACTURADO, "+
                    "CANTIDAD, "+
                    "SUBTOTAL " +
                    "FROM Detalle_Pedido "+
                    "WHERE ID_Pedido =:id ",
            nativeQuery = true
    )
    Factura FacturarPedido(@Param("id") Long id);
}
