package com.codepole.publisher.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {

    @Autowired
    PublishService publishService;

    @GetMapping("/")
    public void publish(@RequestBody ProductIdDto id) {
        publishService.publish(id);
    }
}
