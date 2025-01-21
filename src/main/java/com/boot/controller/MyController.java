package com.boot.controller;

import com.boot.beans.MyRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class MyController {

    @PostMapping("/validate")
    public String validate(@RequestBody @Valid MyRequest myRequest) {
        return "Validated Successfully!";
    }
}
