package com.jnr.deliver.service;

import com.jnr.deliver.dto.ProductDTO;
import com.jnr.deliver.model.Product;
import com.jnr.deliver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> productList = productRepository.findAllByOrderByNameAsc();
        return productList.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }

}
