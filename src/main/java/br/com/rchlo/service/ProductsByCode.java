package br.com.rchlo.service;

import br.com.rchlo.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsByCode {

    public List<Product> filter(Long code, List<Product> products) {
        validateParameters(code, products);
        return products
                .stream()
                .filter(product -> product.getCode().equals(code))
                .collect(Collectors.toList());

       /**List<Product> filteredProducts = new ArrayList<>();

        products.forEach(product -> {
            // (code.hashCode() == product.hashCode())
            if (product.getCode().equals(code)) filteredProducts.add(product);
        });

         return filteredProducts;
        **/
    }

    private void validateParameters(Long code, List<Product> products) {
        if (code == null) throw new IllegalArgumentException("code should not be null");
        if (products == null) throw new IllegalArgumentException("product list should not be null");
    }

}
