package platzimarket.platzi.market.persistence;

import org.springframework.stereotype.Repository;
import platzimarket.platzi.market.persistence.crud.ProductoCrudRepository;
import platzimarket.platzi.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidadStock) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, true);
    }

    public Producto save (Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete (Producto producto){
         productoCrudRepository.delete(producto);
    }
}
