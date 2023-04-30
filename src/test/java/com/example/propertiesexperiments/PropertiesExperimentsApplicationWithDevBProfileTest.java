package com.example.propertiesexperiments;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("dev-b")
@SpringBootTest
@TestPropertySource(locations = {"/application.properties", "/application-test.properties"})
class PropertiesExperimentsApplicationWithDevBProfileTest {

    @Autowired
    private Environment env;

    @Test
    void contextLoads() {
         /* The properties below are not overridden as in production mode because multi-document property
         files cannot be loaded with @TestPropertySource according to:
         https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config.files.multi-document
         */

        // Should have been override with dev-b.properties value
        assertEquals("/home/diego/wa/properties-experiments", env.getProperty("user.property"));
        assertEquals("/home/diego/wa/properties-experiments", env.getProperty("user.property2"));
        // Should have been override with dev-a.properties value
        assertEquals("/home/diego/wa/properties-experiments", env.getProperty("my.property"));
        // Should have been override with dev-b-test.properties value
        assertEquals("@project.basedir@", env.getProperty("my.property2"));
        // These were surprisingly taken
        assertEquals("dev-b-added-new-prop", env.getProperty("user.property-dev-b"));
        assertEquals("dev-b-test-added-new-prop", env.getProperty("user.property-dev-b-test"));
    }

}
