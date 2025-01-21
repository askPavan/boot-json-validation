package com.boot.beans;


import com.boot.custom.MyEnumDeserializer;
import com.boot.custom.ValidateEnum;
import com.boot.enums.MyEnum;
import com.boot.enums.StatusEnum;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MyRequest {

    @NotNull(message = "Enum value must not be null")
    @ValidateEnum(enumClass = MyEnum.class, message = "Invalid enum value")
    @JsonDeserialize(using = MyEnumDeserializer.class)
    private MyEnum myEnum;

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @Valid
    private Address address;

    @NotNull(message = "Status value must not be null")
    @ValidateEnum(enumClass = StatusEnum.class, message = "Invalid status value")
    @JsonDeserialize(using = MyEnumDeserializer.class)
    private StatusEnum statusEnum;

}
