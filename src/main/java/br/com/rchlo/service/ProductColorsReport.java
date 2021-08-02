package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.stream;

public class ProductColorsReport {
    public Map<Color, Integer> report(List<Product> products) {

        Map<Color, Integer> mapColor = new LinkedHashMap<>();
        stream(Color.values()).forEach(color -> mapColor.put(color, 0));

        products.stream().map(Product::getColor).forEach(color -> mapColor.replace(color, (mapColor.get(color) + 1)));

        return mapColor;
    }
}

