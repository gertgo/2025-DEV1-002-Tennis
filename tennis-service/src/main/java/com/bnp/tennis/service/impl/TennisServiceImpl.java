package com.bnp.tennis.service.impl;

import com.bnp.tennis.repository.client.TennisRepository;
import com.bnp.tennis.service.api.TennisService;
import com.bnp.tennis.service.model.TennisGame;
import org.springframework.stereotype.Service;
import com.bnp.tennis.service.mapper.TennisGameMapper;

@Service
public class TennisServiceImpl implements TennisService {

    private final TennisRepository tennisRepository;
    private final TennisGameMapper mapper;

    public TennisServiceImpl(TennisRepository tennisRepository, TennisGameMapper mapper) {
        this.tennisRepository = tennisRepository;
        this.mapper = mapper;
    }

    @Override
    public TennisGame createGame(TennisGame tennisGame) {
        initScores(tennisGame);

        return mapper.toModel(
            tennisRepository.save(
                mapper.toEntity(tennisGame)));
    }

    private void initScores(TennisGame tennisGame) {
        tennisGame.getPlayer1().setScore(0);
        tennisGame.getPlayer2().setScore(0);
    }
}
