package com.example.linjianhaidemo.service;

import com.example.linjianhaidemo.domain.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductService extends ElasticsearchRepository<Product,Long> {

}
