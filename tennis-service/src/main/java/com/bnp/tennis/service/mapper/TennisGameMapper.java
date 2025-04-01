package com.bnp.tennis.service.mapper;

import org.springframework.stereotype.Component;
import com.bnp.tennis.repository.model.TennisGameEntity;
import com.bnp.tennis.service.model.TennisGame;

@Component
public class TennisGameMapper {
    public TennisGameEntity toEntity(TennisGame tennisGame) {
        TennisGameEntity entity = new TennisGameEntity();
        entity.setId(tennisGame.getId());
        return entity;
    }

    public TennisGame toModel(TennisGameEntity entity) {
        TennisGame model = new TennisGame();
        model.setId(entity.getId());
        return model;
    }
}
