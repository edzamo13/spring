package platzimarket.platzi.market.persistence.crud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import platzimarket.platzi.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
/*
    @Query(value = "Select * from productos where id_categotia =? ", nativeQuery = true)
    List<Producto> getByIdCategoria(int idCategotia);*/

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    // Menor que
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);


}
