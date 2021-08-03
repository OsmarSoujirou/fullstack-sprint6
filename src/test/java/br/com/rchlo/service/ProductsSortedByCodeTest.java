package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

class ProductsSortedByCodeTest {

    private ProductsSortedByCode productsSortedByCode;



    @Test
    void shouldCodeOfTheFirstIndexBeLessThanTheSecond() {
        List<Product> products = List.of(productM1(), productM2());
        List<Product> productsSorted = new ProductsSortedByCode(products).getProductSortedList();

        Long productCode1 = productsSorted.get(0).getCode();
        Long productCode2 = productsSorted.get(1).getCode();
        Assert.assertEquals(-1,productCode1.compareTo(productCode2));
    }


    @Test
    void shouldThrowsExceptionArgumentIsNull() {
        try {
            productsSortedByCode = new ProductsSortedByCode(null);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
        }
    }


    @Test
    void shouldThrowsExceptionArgumentIfListIsEmpty() {
        List<Product> products = List.of();
        try {
            productsSortedByCode = new ProductsSortedByCode(products);
            Assert.fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
        }
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