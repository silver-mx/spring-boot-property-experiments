# SpringBoot Properties Handling

This project experiments with how SpringBoot handles properties.

The tests verify the following:

1) Multi-document files are processed correctly in production but while testing, they are not loaded correctly via `@TestPropertySource`. This is documented in the [Spring docs](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config.files.multi-document).
2) Maven properties like `@project.basedir@` are only expanded in production properties, *i.e.*, in property files places in `src/main/resources`. This is documented in the [Spring docs](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.properties-and-configuration.expand-properties.maven).  
