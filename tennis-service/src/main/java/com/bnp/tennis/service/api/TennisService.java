package com.bnp.tennis.service.api;

import com.bnp.tennis.service.model.TennisGame;

public interface TennisService {
    TennisGame createGame(TennisGame tennisGame);

    TennisGame scorePoint(Long gameId, Long playerId);
}
