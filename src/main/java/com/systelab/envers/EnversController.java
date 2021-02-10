package com.systelab.envers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Envers utilities")
@RestController
@RequestMapping(value = "/envers/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnversController {

    @GetMapping("hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("Hello from the library");
    }

}
