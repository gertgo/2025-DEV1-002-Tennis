package com.bnp.tennis.rest.mapper;

import com.bnp.tennis.rest.dto.TennisGameDto;
import org.springframework.stereotype.Component;
import com.bnp.tennis.service.model.TennisGame;
import com.bnp.tennis.service.model.TennisPlayer;

@Component
public class TennisGameDtoMapper {
    private final TennisPlayerDtoMapper tennisPlayerDtoMapper;

    public TennisGameDtoMapper(TennisPlayerDtoMapper tennisPlayerDtoMapper) {
        this.tennisPlayerDtoMapper = tennisPlayerDtoMapper;
    }

    public TennisGameDto toDto(TennisGame tennisGame) {
        TennisGameDto dto = new TennisGameDto();
        dto.setId(tennisGame.getId());
        dto.setPlayer1(tennisPlayerDtoMapper.toDto(tennisGame.getPlayer1()));
        dto.setPlayer2(tennisPlayerDtoMapper.toDto(tennisGame.getPlayer2()));
        return dto;
    }

    public TennisGame toModel(TennisGameDto dto) {
        TennisGame model = new TennisGame();
        model.setId(dto.getId());
        model.setPlayer1(tennisPlayerDtoMapper.toModel(dto.getPlayer1()));
        model.setPlayer2(tennisPlayerDtoMapper.toModel(dto.getPlayer2()));
        return model;
    }
}
