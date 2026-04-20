package com.challenge.product.service;

import com.challenge.product.client.ProductFeignClient;
import com.challenge.product.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor // generate constructor for dependency injection
public class ProductService {

    private final ProductFeignClient productFeignClient;

    public List<ProductDTO> getProducts() {
        return productFeignClient.getAllProducts();
    }

    public ProductDTO getById(Long id) {
        return productFeignClient.getProductById(id);
    }
}