package com.bnp.tennis.application;

import com.bnp.tennis.repository.client.TennisRepository;
//import com.bnp.tennis.rest.dto.TennisGameDto;
import com.bnp.tennis.rest.dto.TennisGameDto;
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
@EnableJpaRepositories(basePackages = "com.bnp.tennis.repository.client")
@EntityScan(basePackages = "com.bnp.tennis.repository.model")
@Transactional
public class TennisServiceImplTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TennisRepository tennisRepository;

    @Test
    public void testStartNewGame() {
        var gameId = this.restTemplate.postForObject(
            "/api/ui/tennis/newGame",
            new TennisGameDto(),
            TennisGameDto.class);

        var game = tennisRepository.findById(gameId.getId());
        assertThat(game).isNotEmpty();
    }
}
