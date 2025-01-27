package com.boot.custom.deserailizers;

import com.boot.enums.MyEnum;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;

public class MyEnumDeserializer extends JsonDeserializer<MyEnum> {

    @Override
    public MyEnum deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = ((TextNode) p.getCodec().readTree(p)).textValue();
        try {
            return MyEnum.valueOf(value); // Try to map string to enum
        } catch (IllegalArgumentException e) {
            // If invalid, return null (Spring validation will handle this as a @NotNull violation)
            return null;
        }
    }
}
