package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    private ProductService(ProductRepository productRepository){ this.productRepository = productRepository;
    }


    public void addNewProduct(Product product){ productRepository.save(product);
    }

    public void delete(String name){ productRepository.deleteByName(name);

    }

    public List<Product> getAllProducts() {return productRepository.getAllProducts();
    }
}
