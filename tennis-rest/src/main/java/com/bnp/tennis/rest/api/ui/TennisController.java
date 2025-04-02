package com.bnp.tennis.rest.api.ui;

import com.bnp.tennis.rest.mapper.TennisGameDtoMapper;
import com.bnp.tennis.rest.dto.TennisGameDto;
import com.bnp.tennis.service.exception.PlayerNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bnp.tennis.service.api.TennisService;

@RestController
@RequestMapping("api/tennis")
public class TennisController {
    private final TennisService tennisService;
    private final TennisGameDtoMapper mapper;

    public TennisController(TennisService tennisService, TennisGameDtoMapper mapper) {
        this.tennisService = tennisService;
        this.mapper = mapper;
    }

    @PostMapping("/newGame")
    public ResponseEntity<TennisGameDto> createNewGame(@RequestBody TennisGameDto gameDto) {
        return ResponseEntity.ok(
            mapper.toDto(
                tennisService.createGame(
                    mapper.toModel(gameDto))));
    }

    @PutMapping("{gameId}/scorePoint/{playerId}")
    public ResponseEntity<TennisGameDto> scorePoint(@PathVariable Long gameId, @PathVariable Long playerId) {
        try {
            return ResponseEntity.ok(
                mapper.toDto(
                    tennisService.scorePoint(gameId, playerId)));
        } catch (PlayerNotFound e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
