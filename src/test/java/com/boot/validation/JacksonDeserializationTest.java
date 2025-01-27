package com.boot.validation;

import com.boot.enums.MyEnum;
import com.boot.enums.StatusEnum;
import com.boot.custom.deserailizers.GenericEnumDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JacksonDeserializationTest {

    @Test
    public void testEnumDeserialization() throws Exception {
        // Set up ObjectMapper with the custom deserializer
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(MyEnum.class, new GenericEnumDeserializer<>(MyEnum.class));
        module.addDeserializer(StatusEnum.class, new GenericEnumDeserializer<>(StatusEnum.class));
        objectMapper.registerModule(module);

        // Test deserialization for MyEnum
        String jsonMyEnum = "\"VALUE1\"";
        MyEnum myEnumResult = objectMapper.readValue(jsonMyEnum, MyEnum.class);
        assertEquals(MyEnum.VALUE1, myEnumResult);

        // Test deserialization for StatusEnum
        String jsonStatusEnum = "\"ACTIVE\"";
        StatusEnum statusEnumResult = objectMapper.readValue(jsonStatusEnum, StatusEnum.class);
        assertEquals(StatusEnum.ACTIVE, statusEnumResult);
    }
}
