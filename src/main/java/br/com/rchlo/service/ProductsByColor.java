package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsByColor {
    public  List<Product> filter(Enum<Color> colorFilter, List<Product> products) {
        validateParameters(colorFilter, products);
        return products
                .stream()
                .filter(product -> product.getColor().equals(colorFilter))
                .collect(Collectors.toList());
    }

    private void validateParameters(Enum<Color> color, List<Product> products) {
        if (color == null) throw new IllegalArgumentException("color should not be null");
        if (products == null) throw new IllegalArgumentException("product list should not be null");
    }
}
