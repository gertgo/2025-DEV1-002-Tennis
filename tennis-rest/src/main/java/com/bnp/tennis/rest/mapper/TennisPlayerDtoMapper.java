package com.bnp.tennis.rest.mapper;

import org.springframework.stereotype.Component;
import com.bnp.tennis.rest.dto.TennisPlayerDto;
import com.bnp.tennis.service.model.TennisPlayer;

@Component
public class TennisPlayerDtoMapper {
    public TennisPlayerDto toDto(TennisPlayer tennisPlayer) {
        TennisPlayerDto dto = new TennisPlayerDto();
        dto.setId(tennisPlayer.getId());
        dto.setName(tennisPlayer.getName());
        dto.setScore(tennisPlayer.getScore());
        dto.setAdvantage(tennisPlayer.getAdvantage());
        dto.setWin(tennisPlayer.getWin());
        return dto;
    }

    public TennisPlayer toModel(TennisPlayerDto entity) {
        TennisPlayer model = new TennisPlayer();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setScore(entity.getScore());
        model.setAdvantage(entity.getAdvantage());
        model.setWin(entity.getWin());
        return model;
    }
}
