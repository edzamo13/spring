package platzimarket.platzi.market.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "compras_productos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ComprasProducto {
    @EmbeddedId
    private ComprasProductoPk id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;


}