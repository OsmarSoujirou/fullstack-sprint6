package br.com.rchlo.service;

import br.com.rchlo.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsByEffectivePriceRange {

    public List<Product> filter(BigDecimal minimumPrice, BigDecimal maximumPrice, List<Product> products) {

        validateParameters(minimumPrice, maximumPrice, products);

        return products.stream()
                .filter(product -> compareValueFilter(minimumPrice, maximumPrice, product.getPriceClosing()))
                .collect(Collectors.toList());
    }

    private Boolean compareValueFilter(BigDecimal minimum, BigDecimal maximum, BigDecimal compared) {
        return minimum.compareTo(compared) <= 0 && maximum.compareTo(compared) >= 0;
    }

    private void validateParameters(BigDecimal minimumPrice, BigDecimal maximumPrice, List<Product> products) {
        if (minimumPrice == null) throw new IllegalArgumentException("minimum price should not be null");
        if (maximumPrice == null) throw new IllegalArgumentException("maximum price should not be null");
        if (products == null) throw new IllegalArgumentException("product list should not be null");
    }

}
