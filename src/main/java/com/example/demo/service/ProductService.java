package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.sql.SQLException;
import java.io.File;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    private ProductService(ProductRepository productRepository){ this.productRepository = productRepository;
    }


    public void addNewProduct(Product product){ productRepository.save(product);
    }

    public void deleteProduct(int id){productRepository.deleteById((long) id);
    }

    public List<Product> findAll() {return productRepository.findAll();
    }

    public void savetodb() throws JAXBException {
        File file = new File("C:\\Users\\jgurb\\Downloads\\demo\\demo\\lista.xml");

        JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        List<Product> products = (List<Product>) jaxbUnmarshaller.unmarshal(file);



        System.out.println(products);
    }

    /*    public static void savetodb() //throws JAXBException
        {
            File file = new File("C:\\Users\\jgurb\\Downloads\\demo\\demo\\lista.xml");

            final String INSERT_SQL = "INSERT INTO products (id, name, price) VALUES (?, ?, ?)";
            final String DATABASE_URL = "jdbc:h2:mem:testdb";
            final String DATABASE_USERNAME = "sa";
            final String DATABASE_PASSWORD = "";

            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                List<Product> products = (List<Product>) jaxbUnmarshaller.unmarshal(file);

                try (Connection conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD)) {
                    conn.setAutoCommit(false);
                    try (PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
                        for (Product product : products) {
                            stmt.setInt(1, product.getId());
                            stmt.setString(2, product.getName());
                            stmt.setInt(3, product.getPrice());
                            stmt.addBatch();
                        }
                        stmt.executeBatch();
                        conn.commit();
                    } catch (SQLException e) {
                        conn.rollback();
                        throw e;
                    }
                }
            } catch (JAXBException | SQLException e) {
                e.printStackTrace();
                }

        }*/
    }

