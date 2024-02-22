package com.codepole.publisher.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishService {

    @Autowired
    private EventPublisher eventPublisher;

    private final ProductRepository productRepository;

    public PublishService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // try to publish product to web store
    public void publish(ProductIdDto id) {
        Iterable<Product> allProducts = productRepository.findAll();

        Product product = null;
        for (Product product1 : allProducts) {
            if (product1.getId().equals(id.id())) {
                product = product1;
            }
        }

        // add short description for web store
        String longDesc = product.getLongDesc();
        product.setShortDesc(longDesc.substring(0, 100));

        ProductNameValidator.validate(product);
        product.setPublished(true);
        productRepository.save(product);

        if (!product.getTypeOfRoom().isBlank() && !product.getShape().isBlank() && product.getWeight() != 0) {
            eventPublisher.sendFurnitureEvent(product);
        } else {
            eventPublisher.sendClothesEvent(product);
        }
    }
}
