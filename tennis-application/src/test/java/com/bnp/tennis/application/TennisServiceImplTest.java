package com.bnp.tennis.application;

import com.bnp.tennis.repository.client.TennisRepository;
//import com.bnp.tennis.rest.dto.TennisGameDto;
import com.bnp.tennis.rest.dto.TennisGameDto;
import com.bnp.tennis.rest.dto.TennisPlayerDto;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
//@EnableJpaRepositories(basePackages = "com.bnp.tennis.repository.client")
//@EntityScan(basePackages = "com.bnp.tennis.repository.model")
@Transactional
public class TennisServiceImplTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TennisRepository tennisRepository;

    @Test
    public void testStartNewGame() {
        var game = this.restTemplate.postForObject(
            "/api/tennis/newGame",
            new TennisGameDto(),
            TennisGameDto.class);

        var savedGame = tennisRepository.findById(game.getId());
        assertThat(savedGame).isNotEmpty();
    }

    @Test
    public void testStartGameWithPlayers() {
        TennisGameDto request = new TennisGameDto();
        TennisPlayerDto player1 = new TennisPlayerDto();
        player1.setName("player1");
        request.setPlayer1(player1);
        TennisPlayerDto player2 = new TennisPlayerDto();
        player2.setName("player2");
        request.setPlayer2(player2);

        var game = this.restTemplate.postForObject(
            "/api/tennis/newGame",
            request,
            TennisGameDto.class);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(game.getPlayer1().getName()).isEqualTo(player1.getName());
            softly.assertThat(game.getPlayer2().getName()).isEqualTo(player2.getName());

            var savedGame = tennisRepository.findById(game.getId());
            softly.assertThat(savedGame).isNotEmpty();
            softly.assertThat(game.getPlayer1().getId()).isNotNull();
            softly.assertThat(game.getPlayer1().getName()).isEqualTo(player1.getName());
            softly.assertThat(game.getPlayer2().getId()).isNotNull();
            softly.assertThat(game.getPlayer2().getName()).isEqualTo(player2.getName());
        });
    }
}
