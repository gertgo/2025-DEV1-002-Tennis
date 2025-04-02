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
        var player = getPlayer(tennisGame, playerId);

        if (isAdvantage(tennisGame)) {
            if(noAdvantageYet(tennisGame)) {
                player.setAdvantage(true);
            } else {
                resetAdvantage(tennisGame);
            }
        } else {
            player.setScore(getNewScore(player.getScore()));
        }

    }

    private TennisPlayerEntity getPlayer(TennisGameEntity tennisGame, Long playerId) {
        if (Objects.equals(tennisGame.getPlayer1().getId(), playerId)) {
            return tennisGame.getPlayer1();
        } else if(Objects.equals(tennisGame.getPlayer2().getId(), playerId)) {
            return tennisGame.getPlayer2();
        }
        throw new RuntimeException();
    }

    private int getNewScore(int currentScore) {
        return switch (currentScore) {
            case 0 -> 15;
            case 15 -> 30;
            case 30 -> 40;
            default -> throw new IllegalArgumentException("Ongeldige score: " + currentScore);
        };
    }

    private boolean isAdvantage(TennisGameEntity tennisGame) {
        return Objects.equals(tennisGame.getPlayer1().getScore(), 40)
            && Objects.equals(tennisGame.getPlayer2().getScore(), 40);
    }

    private void resetAdvantage(TennisGameEntity tennisGame) {
        tennisGame.getPlayer1().setAdvantage(false);
        tennisGame.getPlayer2().setAdvantage(false);
    }

    private boolean noAdvantageYet(TennisGameEntity tennisGame) {
        return !tennisGame.getPlayer1().getAdvantage() && !tennisGame.getPlayer2().getAdvantage();
    }
}
