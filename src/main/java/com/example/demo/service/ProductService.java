package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.sql.SQLException;
import java.io.File;
import java.sql.SQLException;

@Service
public class ProductService {

    private ProductRepository productRepository;

    private ProductService(ProductRepository productRepository){ this.productRepository = productRepository;
    }


    public void addNewProduct(Product product){ productRepository.save(product);
    }

    public void delete(Long id){ productRepository.deleteById(id);

    }
    public List<Product> findAll() {return productRepository.findAll();
    }

    @XmlRootElement(name = "product")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class MyObject {

        @XmlElement
        private Long id;
        @XmlElement
        private String name;


        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }


    }
    public void saveDataFromXML() throws JAXBException, SQLException {
        JAXBContext jaxbContext = JAXBContext.newInstance(MyObject.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        MyObject myObject = (MyObject) jaxbUnmarshaller.unmarshal(new File("lista.xml") );

        String insertSql = "INSERT INTO mytable (id, name) VALUES (?, ?)";
        try (
                Connection conn = DriverManager.getConnection("jdbc:h2:mem:zoo", "sa", "");
                PreparedStatement statement = conn.prepareStatement(insertSql)) {
            statement.setLong(1, myObject.getId());
            statement.setString(2, myObject.getName());
            statement.executeUpdate();
        }
    }


}
