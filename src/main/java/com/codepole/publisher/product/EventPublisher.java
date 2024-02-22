package com.codepole.publisher.product;

import org.springframework.stereotype.Service;

interface EventPublisher {

    void sendClothesEvent(Product product);

    void sendFurnitureEvent(Product product);
}
