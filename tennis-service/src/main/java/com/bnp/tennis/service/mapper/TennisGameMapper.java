package com.bnp.tennis.service.mapper;

import org.springframework.stereotype.Component;
import com.bnp.tennis.repository.model.TennisGameEntity;
import com.bnp.tennis.service.model.TennisGame;

@Component
public class TennisGameMapper {
    private final TennisPlayerMapper tennisPlayerMapper;

    public TennisGameMapper(TennisPlayerMapper tennisPlayerMapper) {
        this.tennisPlayerMapper = tennisPlayerMapper;
    }

    public TennisGameEntity toEntity(TennisGame tennisGame) {
        TennisGameEntity entity = new TennisGameEntity();
        entity.setId(tennisGame.getId());
        entity.setPlayer1(tennisPlayerMapper.toEntity(tennisGame.getPlayer1()));
        entity.setPlayer2(tennisPlayerMapper.toEntity(tennisGame.getPlayer2()));
        return entity;
    }

    public TennisGame toModel(TennisGameEntity entity) {
        TennisGame model = new TennisGame();
        model.setId(entity.getId());
        model.setPlayer1(tennisPlayerMapper.toModel(entity.getPlayer1()));
        model.setPlayer2(tennisPlayerMapper.toModel(entity.getPlayer2()));
        return model;
    }
}
