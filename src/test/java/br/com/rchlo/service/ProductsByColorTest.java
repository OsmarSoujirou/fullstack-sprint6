package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class ProductsByColorTest {

     private ProductsByColor productsByColor;

     @BeforeEach
     void setUp() {
         productsByColor = new ProductsByColor();
     }

     @Test
     void shouldFilterTwoProducts() {
        List<Product> products = List.of(productM1(), productM2());

        List<Product> filteredProducts = productsByColor.filter(Color.BLUE, products);
        assertEquals(2, filteredProducts.size());

    }
    @Test
    void shouldReturnsEmptyListEmpty(){
        List<Product> products = List.of();

        List<Product> filteredProducts = productsByColor.filter(Color.BLUE, products);
        assertEquals(0, filteredProducts.size());

    }
    @Test
    void shouldThrowsExceptionNullColor(){
        List<Product> products = List.of();

        try {
            productsByColor.filter(null, products);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {  }


    }

    private Product productM1() {
        return new Product(14124998L,
                "Camiseta",
                "Camiseta Infantil...",
                "camiseta-infantil",
                "Nintendo",
                new BigDecimal("39.90"),
                new BigDecimal("5.0"),
                Color.BLUE,
                116,
                "cd948d80fe8a1fdc873f8dca1f3c4c468253bf1d.jpg",
                Set.of(Size.SMALL, Size.MEDIUM));
    }

    private Product productM2() {
        return new Product(13834193L,
                "Jaqueta",
                "Jaqueta Puffer...",
                "jaqueta-puffer",
                "Nintendo",
                new BigDecimal("199.90"),
                null,
                Color.BLUE,
                147,
                "3107b7473df334c6ff206cd78d16dec86d7dfe9a.jpg",
                Set.of(Size.LARGE, Size.EXTRA_LARGE));
    }

}


