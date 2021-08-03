package br.com.rchlo.main;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.service.ProductsSortedByCode;

public class ProductsSortedByCodeMain {
    public static void main(String[] args) {

        var productSorted = new ProductsSortedByCode(ProductRepository.all());
        productSorted.getProductSortedList().forEach(product -> System.out.println(product));

    }
}
