package com.boot.configs;

import com.boot.custom.deserailizers.GenericEnumDeserializer;
import com.boot.enums.MyEnum;
import com.boot.enums.StatusEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();

        // Registering custom deserializer for enums
        SimpleModule module = new SimpleModule();
        module.addDeserializer(MyEnum.class, new GenericEnumDeserializer<>(MyEnum.class));
        module.addDeserializer(StatusEnum.class, new GenericEnumDeserializer<>(StatusEnum.class));

        // You can register other enums as needed
        objectMapper.registerModule(module);

        return objectMapper;
    }

    @Bean
    public MappingJackson2HttpMessageConverter jacksonMessageConverter(ObjectMapper objectMapper) {
        return new MappingJackson2HttpMessageConverter(objectMapper);
    }
}
