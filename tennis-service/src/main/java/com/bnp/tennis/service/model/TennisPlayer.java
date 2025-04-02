package com.bnp.tennis.service.model;

public class TennisPlayer {
    private Long id;
    private String name;
    private Integer score;
    private Boolean advantage;
    private Boolean win;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getAdvantage() {
        return advantage;
    }

    public void setAdvantage(Boolean advantage) {
        this.advantage = advantage;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }
}
