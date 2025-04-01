package com.bnp.tennis.rest;

import com.bnp.tennis.rest.dto.TennisGameDto;
import org.springframework.stereotype.Component;
import com.bnp.tennis.service.model.TennisGame;

@Component
public class TennisGameDtoMapper {
    public TennisGameDto toDto(TennisGame tennisGame) {
        TennisGameDto dto = new TennisGameDto();
        dto.setId(tennisGame.getId());
        return dto;
    }

    public TennisGame toModel(TennisGameDto entity) {
        TennisGame model = new TennisGame();
        model.setId(entity.getId());
        return model;
    }
}
