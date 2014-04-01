package com.orbitz.example.hystrix;

import com.orbitz.example.hystrix.model.Mapping;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

/**
 * Main entry point for the example.
 */
public class SpringHystrixExample {

    public static void main(String... args) {
        MappingService mappingService =
                new AnnotationConfigApplicationContext(SpringConfig.class)
                        .getBean(MappingService.class);

        mappingService.insertMapping(new Mapping("some key", "ORB", "en_US", "Chicago"));
        Assert.isTrue(mappingService.findMappingById("some key") != null);
    }
}
