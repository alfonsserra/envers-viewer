package com.systelab.envers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/beacon/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnversController {

    @GetMapping("hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("Hello from the library");
    }

}
