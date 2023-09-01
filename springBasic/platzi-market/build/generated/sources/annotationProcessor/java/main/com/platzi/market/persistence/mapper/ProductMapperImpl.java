package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-08T18:57:42-0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Product toProduct(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        Product product = new Product();

        if ( producto.getIdProducto() != null ) {
            product.setProductId( producto.getIdProducto() );
        }
        if ( producto.getPrecioVenta() != null ) {
            product.setPrice( producto.getPrecioVenta() );
        }
        product.setName( producto.getNombre() );
        if ( producto.getEstado() != null ) {
            product.setActive( producto.getEstado() );
        }
        if ( producto.getCantidadStock() != null ) {
            product.setStock( producto.getCantidadStock() );
        }
        product.setCategory( categoryMapper.toCategory( producto.getCategoria() ) );
        if ( producto.getIdCategoria() != null ) {
            product.setCategoryId( producto.getIdCategoria() );
        }

        return product;
    }

    @Override
    public List<Product> toProducts(List<Producto> productos) {
        if ( productos == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productos.size() );
        for ( Producto producto : productos ) {
            list.add( toProduct( producto ) );
        }

        return list;
    }

    @Override
    public Producto toProducto(Product product) {
        if ( product == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setEstado( product.isActive() );
        producto.setCantidadStock( product.getStock() );
        producto.setCategoria( categoryMapper.toCategoria( product.getCategory() ) );
        producto.setIdProducto( product.getProductId() );
        producto.setPrecioVenta( product.getPrice() );
        producto.setIdCategoria( product.getCategoryId() );
        producto.setNombre( product.getName() );

        return producto;
    }
}
