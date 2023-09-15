package com.ezamora.productservice.service.impl;

import com.ezamora.productservice.repository.impl.ProductRepository;
import com.ezamora.productservice.service.ProductService;
import com.ezamora.productservice.service.dto.ProductDto;
import com.ezamora.productservice.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public Flux<ProductDto> getAll() {
    return this.productRepository.findAll()
        .map(ProductMapper.INSTANCE::toProductDto);
  }


  @Override
  public Flux<ProductDto> getProductByPriceRange(int min, int max) {
    return this.productRepository.findByPriceBetween(Range.open(min, max))
        .map(ProductMapper.INSTANCE::toProductDto);
  }
  @Override
  public Mono<ProductDto> getProductById(String productId) {
    return this.productRepository.findById(productId)
        .map(ProductMapper.INSTANCE::toProductDto);
  }

  @Override
  public Mono<ProductDto> insertProduct(Mono<ProductDto> productDtoMono) {
    return productDtoMono
        .map(ProductMapper.INSTANCE::toProduct)
        .flatMap(this.productRepository::insert)
        .map(ProductMapper.INSTANCE::toProductDto);
  }

  @Override
  public Mono<ProductDto> updateProduct(String id, Mono<ProductDto> productDtoMono) {
    return this.productRepository.findById(id)
        .flatMap(product -> productDtoMono
            .map(ProductMapper.INSTANCE::toProduct)
            // .doOnNext(productPrint -> System.out.println("productPrint" + productPrint))
            .doOnNext(productSave -> productSave.setId(product.getId())))
        .flatMap(this.productRepository::save)
        .map(ProductMapper.INSTANCE::toProductDto);
  }


  public Mono<Void> deleteProduct(String id) {
    return this.productRepository.deleteById(id);
  }


}
