package com.bnp.tennis.service.impl;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.bnp.tennis.repository.client.TennisRepository;
import com.bnp.tennis.repository.model.TennisGameEntity;
import com.bnp.tennis.repository.model.TennisPlayerEntity;
import java.util.Optional;
import org.mockito.Captor;
import org.mockito.ArgumentCaptor;
import com.bnp.tennis.service.mapper.TennisGameMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TennisServiceImplTest {

    @Mock
    private TennisRepository tennisRepository;

    @Mock
    private TennisGameMapper mapper;

    @Captor
    private ArgumentCaptor<TennisGameEntity> gameCaptor;


    @InjectMocks
    private TennisServiceImpl tennisService;

    @ParameterizedTest
    @CsvSource({
        "0, 0, 1, 15, 0",
        "15, 0, 1, 30, 0",
        "30, 0, 1, 40, 0",
        "15, 15, 2, 15, 30",
        "0, 15, 2, 0, 30"
    })
    public void testScorePoint(int initialScorePlayer1, int initialScorePlayer2, Long scoringPlayerId, int newScorePlayer1, int newScorePlayer2) {
        TennisGameEntity game = getTennisGameEntity(initialScorePlayer1, initialScorePlayer2, null, null);
        when(tennisRepository.findById(1L)).thenReturn(Optional.of(game));
        when(tennisRepository.save(any(TennisGameEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

        tennisService.scorePoint(1L, scoringPlayerId);

        verify(tennisRepository).save(gameCaptor.capture());
        TennisGameEntity updatedGame = gameCaptor.getValue();
        assertThat(updatedGame.getPlayer1().getScore()).isEqualTo(newScorePlayer1);
        assertThat(updatedGame.getPlayer2().getScore()).isEqualTo(newScorePlayer2);
    }

    @ParameterizedTest
    @CsvSource({
        "40, 40, false, false, 1, 40, 40, true, false",
        "40, 40, false, false, 2, 40, 40, false, true",
        "40, 40, true, false, 2, 40, 40, false, false"
    })
    public void testScorePointAdvantage(int initialScorePlayer1, int initialScorePlayer2, boolean initialAdvantagePlayer1, boolean initialAdvantagePlayer2,
                                        Long scoringPlayerId,
                                        int newScorePlayer1, int newScorePlayer2, boolean newAdvantagePlayer1, boolean newAdvantagePlayer2) {
        TennisGameEntity game = getTennisGameEntity(initialScorePlayer1, initialScorePlayer2, initialAdvantagePlayer1, initialAdvantagePlayer2);
        when(tennisRepository.findById(1L)).thenReturn(Optional.of(game));
        when(tennisRepository.save(any(TennisGameEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

        tennisService.scorePoint(1L, scoringPlayerId);

        verify(tennisRepository).save(gameCaptor.capture());
        TennisGameEntity updatedGame = gameCaptor.getValue();
        assertThat(updatedGame.getPlayer1().getScore()).isEqualTo(newScorePlayer1);
        assertThat(updatedGame.getPlayer2().getScore()).isEqualTo(newScorePlayer2);
        assertThat(updatedGame.getPlayer1().getAdvantage()).isEqualTo(newAdvantagePlayer1);
        assertThat(updatedGame.getPlayer2().getAdvantage()).isEqualTo(newAdvantagePlayer2);
    }

    @ParameterizedTest
    @CsvSource({
        "40, 40, false, false, 1, false, false",
        "40, 40, false, false, 2, false, false",
        "40, 40, true, false, 2, false, false",
        "40, 40, true, false, 1, true, false",
    })
    public void testScorePointWin(int initialScorePlayer1, int initialScorePlayer2, boolean initialAdvantagePlayer1, boolean initialAdvantagePlayer2,
                                        Long scoringPlayerId, boolean player1Win, boolean player2Win) {
        TennisGameEntity game = getTennisGameEntity(initialScorePlayer1, initialScorePlayer2, initialAdvantagePlayer1, initialAdvantagePlayer2);
        when(tennisRepository.findById(1L)).thenReturn(Optional.of(game));
        when(tennisRepository.save(any(TennisGameEntity.class))).thenAnswer(invocation -> invocation.getArgument(0));

        tennisService.scorePoint(1L, scoringPlayerId);

        verify(tennisRepository).save(gameCaptor.capture());
        TennisGameEntity updatedGame = gameCaptor.getValue();
        assertThat(updatedGame.getPlayer1().getWin()).isEqualTo(player1Win);
        assertThat(updatedGame.getPlayer2().getWin()).isEqualTo(player2Win);
    }

    private TennisGameEntity getTennisGameEntity(int scorePlayer1, int scorePlayer2, Boolean initialAdvantagePlayer1, Boolean initialAdvantagePlayer2) {
        TennisGameEntity game = new TennisGameEntity();
        game.setId(1L);
        TennisPlayerEntity player1 = new TennisPlayerEntity();
        player1.setId(1L);
        player1.setName("player1");
        player1.setScore(scorePlayer1);
        player1.setAdvantage(initialAdvantagePlayer1);
        player1.setWin(false);
        game.setPlayer1(player1);
        TennisPlayerEntity player2 = new TennisPlayerEntity();
        player2.setId(2L);
        player2.setName("player2");
        player2.setScore(scorePlayer2);
        player2.setAdvantage(initialAdvantagePlayer2);
        player2.setWin(false);
        game.setPlayer2(player2);

        return game;
    }
}
