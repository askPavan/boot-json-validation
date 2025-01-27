package com.boot.custom.deserailizers;

import com.boot.enums.StatusEnum;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;

public class StatusEnumDeserializer extends JsonDeserializer<StatusEnum> {

    @Override
    public StatusEnum deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = ((TextNode) p.getCodec().readTree(p)).textValue();
        try {
            return StatusEnum.valueOf(value);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
