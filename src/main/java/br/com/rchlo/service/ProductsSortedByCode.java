package br.com.rchlo.service;

import br.com.rchlo.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsSortedByCode {

    private final List<Product> productsSortedList;

    public ProductsSortedByCode(List<Product> products) {
        if (products == null || products.isEmpty()) throw new IllegalArgumentException("product list should not be null");
        this.productsSortedList = new ArrayList<>(products);
    }

    public List<Product> getProductSortedList() {
        return this.productsSortedList.stream().sorted().collect(Collectors.toList());
    }
}