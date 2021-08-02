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

public class ProductColorsReportTest {
    private ProductColorsReport productsColorsReport;

    @BeforeEach
    void setUp() {
        productsColorsReport = new ProductColorsReport();
    }

    @Test
    void expectReturnWithQuantityAsMock() {
        List<Product> products = List.of(mockP1(), mockP2());
        assertEquals(2, productsColorsReport.report(products).get(Color.BLUE));
    }

    @Test
    void expectReturnWithEmptyList() {

        List<Product> products = List.of();
        for (Color color : Color.values()) {
            assertEquals(0, productsColorsReport.report(products).get(color));
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
                Set.of(Size.SMALL, Size.MEDIUM));
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
                Set.of(Size.LARGE, Size.EXTRA_LARGE));
    }
}
