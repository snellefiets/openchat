package de.ite.openchat.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusApi {

    @GetMapping
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("{\"status\": \"Application is running!\"}");
    }
}
