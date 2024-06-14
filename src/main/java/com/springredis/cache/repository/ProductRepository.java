package com.springredis.cache.repository;

import org.springframework.data.repository.CrudRepository;

import com.springredis.cache.dto.ProductDTO;

public interface ProductRepository extends CrudRepository<ProductDTO, Integer> {

}
