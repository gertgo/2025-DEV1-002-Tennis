package com.bnp.tennis.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

@Entity
public class TennisGameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(targetEntity = TennisPlayerEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "player1_Id")
    private TennisPlayerEntity player1;
    @OneToOne(targetEntity = TennisPlayerEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "player2_Id")
    private TennisPlayerEntity player2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TennisPlayerEntity getPlayer1() {
        return player1;
    }

    public void setPlayer1(TennisPlayerEntity player1) {
        this.player1 = player1;
    }

    public TennisPlayerEntity getPlayer2() {
        return player2;
    }

    public void setPlayer2(TennisPlayerEntity player2) {
        this.player2 = player2;
    }
}
