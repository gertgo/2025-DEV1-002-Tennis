package com.bnp.tennis.rest.api.ui;

import com.bnp.tennis.rest.dto.TennisGameDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ui/tennis")
public class TennisController {

    @PostMapping(name = "/newGame", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TennisGameDto> createNewGame() {
        return ResponseEntity.ok(new TennisGameDto());
    }

    @GetMapping("/score")
    public ResponseEntity<String> getScore() {
        return ResponseEntity.ok("test");
    }
}
