package com.bnp.tennis.rest.dto;

public class TennisGameDto {
    private Long id;
    private TennisPlayerDto player1;
    private TennisPlayerDto player2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TennisPlayerDto getPlayer1() {
        return player1;
    }

    public void setPlayer1(TennisPlayerDto player1) {
        this.player1 = player1;
    }

    public TennisPlayerDto getPlayer2() {
        return player2;
    }

    public void setPlayer2(TennisPlayerDto player2) {
        this.player2 = player2;
    }
}
