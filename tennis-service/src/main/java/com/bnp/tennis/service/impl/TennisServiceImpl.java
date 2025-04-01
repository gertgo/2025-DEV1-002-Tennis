package com.bnp.tennis.service.impl;

import com.bnp.tennis.repository.client.TennisRepository;
import com.bnp.tennis.repository.model.TennisGameEntity;
import com.bnp.tennis.repository.model.TennisPlayerEntity;
import com.bnp.tennis.service.api.TennisService;
import com.bnp.tennis.service.model.TennisGame;
import org.springframework.stereotype.Service;
import com.bnp.tennis.service.mapper.TennisGameMapper;
import java.util.Objects;
import com.bnp.tennis.service.model.TennisPlayer;

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

    @Override
    public TennisGame scorePoint(Long gameId, Long playerId) {
        var game = tennisRepository.findById(gameId).orElseThrow();
        addPoint(game, playerId);

        return mapper.toModel(
            tennisRepository.save(game));
    }

    private void initScores(TennisGame tennisGame) {
        tennisGame.getPlayer1().setScore(0);
        tennisGame.getPlayer2().setScore(0);
    }

    private void addPoint(TennisGameEntity tennisGame, Long playerId) {
        getPlayer(tennisGame, playerId).setScore(15);
    }

    private TennisPlayerEntity getPlayer(TennisGameEntity tennisGame, Long playerId) {
        if (Objects.equals(tennisGame.getPlayer1().getId(), playerId)) {
            return tennisGame.getPlayer1();
        } else if(Objects.equals(tennisGame.getPlayer2().getId(), playerId)) {
            return tennisGame.getPlayer2();
        }
        throw new RuntimeException();
    }
}
