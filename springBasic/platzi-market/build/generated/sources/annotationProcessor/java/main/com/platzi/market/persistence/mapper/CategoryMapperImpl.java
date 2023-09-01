package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-08T18:57:42-0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category toCategory(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        Category category = new Category();

        if ( categoria.getEstado() != null ) {
            category.setActive( categoria.getEstado() );
        }
        category.setCategory( categoria.getDescripcion() );
        if ( categoria.getIdCategoria() != null ) {
            category.setCategoryId( categoria.getIdCategoria() );
        }

        return category;
    }

    @Override
    public Categoria toCategoria(Category category) {
        if ( category == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setDescripcion( category.getCategory() );
        categoria.setEstado( category.isActive() );
        categoria.setIdCategoria( category.getCategoryId() );

        return categoria;
    }
}
