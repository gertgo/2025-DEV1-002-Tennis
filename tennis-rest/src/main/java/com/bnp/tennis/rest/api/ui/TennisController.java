package com.bnp.tennis.rest.api.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ui/tennis")
public class TennisController {

    @GetMapping("/score")
    public ResponseEntity<String> getScore() {
        return ResponseEntity.ok("test");
    }
}
