package br.com.rchlo.service;

import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.stream;

public class ProductSizesReport {
    public Map<Size, Integer> report(List<Product> products) {

        Map<Size, Integer> mapSize = new LinkedHashMap<>();
        stream(Size.values()).forEach(color -> mapSize.put(color, 0));

        products.stream()
                .map(Product::getAvailableSizes)
                .forEach(sizes -> {
                    for (Size size : sizes) {
                        mapSize.replace(size, (mapSize.get(size) + 1));
                    }
                });

        return mapSize;
    }
}
