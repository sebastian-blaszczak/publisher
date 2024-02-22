package com.codepole.publisher.product;

public class ProductNameValidator {

    public static void validate(Product product) {
        if(product.name.isBlank()){
            throw new IllegalArgumentException("Name is missing");
        }

        if(product.url.isBlank()){
            throw new IllegalArgumentException("Url is missing");
        }
    }
}
