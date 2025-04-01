package com.bnp.tennis.service.mapper;

import com.bnp.tennis.repository.model.TennisPlayerEntity;
import com.bnp.tennis.service.model.TennisPlayer;
import org.springframework.stereotype.Component;

@Component
public class TennisPlayerMapper {
    public TennisPlayerEntity toEntity(TennisPlayer tennisPlayer) {
        TennisPlayerEntity entity = new TennisPlayerEntity();
        entity.setId(tennisPlayer.getId());
        entity.setName(tennisPlayer.getName());
        entity.setScore(tennisPlayer.getScore());
        entity.setAdvantage(tennisPlayer.getAdvantage());
        return entity;
    }

    public TennisPlayer toModel(TennisPlayerEntity entity) {
        TennisPlayer model = new TennisPlayer();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setScore(entity.getScore());
        model.setAdvantage(entity.getAdvantage());
        return model;
    }
}
