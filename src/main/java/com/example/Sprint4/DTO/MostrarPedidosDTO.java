package com.example.Sprint4.DTO;

import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(
        name="mostrarEstadoPedido",
        entities = {
                @EntityResult(
                        entityClass = MostrarPedidosDTO.class,
                        fields = {
                                @FieldResult(name="id", column = "id"),
                                @FieldResult(name="tiempo_estimado_entrega",column = "tiempo_estimado_entrega"),



                        }
                )
        }
)

public interface MostrarPedidosDTO {
    Long getid();
    Integer gettiempo_estimado_entrega();
}
