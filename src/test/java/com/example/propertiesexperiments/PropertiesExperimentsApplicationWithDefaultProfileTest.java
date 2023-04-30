package com.example.propertiesexperiments;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource(locations = {"/application.properties", "/application-test.properties"})
@SpringBootTest
class PropertiesExperimentsApplicationWithDefaultProfileTest {

    @Autowired
    private Environment env;

    @Test
    void contextLoads() {
        assertEquals("/home/diego/wa/properties-experiments", env.getProperty("user.property"));
        assertEquals("/home/diego/wa/properties-experiments", env.getProperty("user.property2"));
        assertEquals("/home/diego/wa/properties-experiments", env.getProperty("my.property"));
        /* Expected: @project.basedir@ cannot be expanded in test properties.
        See https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.properties-and-configuration.expand-properties.maven */
        assertEquals("@project.basedir@", env.getProperty("my.property2"));
        assertEquals(null, env.getProperty("user.property-dev-b"));
    }

}
