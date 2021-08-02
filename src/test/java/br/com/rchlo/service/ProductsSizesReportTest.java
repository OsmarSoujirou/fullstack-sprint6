package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductsSizesReportTest {
    private ProductSizesReport productsSizesReport;

    @BeforeEach
    void setUp() {
        productsSizesReport = new ProductSizesReport();
    }

    @Test
    void expectReturnWithQuantityAsMock() {
        List<Product> products = List.of(mockP1(), mockP2());
        assertEquals(2, productsSizesReport.report(products).get(Size.SMALL));
    }

    @Test
    void expectReturnWithEmptyList() {

        List<Product> products = List.of();
        for (Size size : Size.values()) {
            assertEquals(0, productsSizesReport.report(products).get(size));
        }

    }

    private Product mockP1() {
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
                Set.of(Size.SMALL));
    }

    private Product mockP2() {
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
                Set.of(Size.SMALL));
    }
}
