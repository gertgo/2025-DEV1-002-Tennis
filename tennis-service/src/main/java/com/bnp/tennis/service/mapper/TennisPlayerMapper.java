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
        return entity;
    }

    public TennisPlayer toModel(TennisPlayerEntity entity) {
        TennisPlayer model = new TennisPlayer();
        model.setId(entity.getId());
        model.setName(entity.getName());
        return model;
    }
}
