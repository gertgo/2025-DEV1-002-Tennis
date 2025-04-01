package com.bnp.tennis.repository.client;

import com.bnp.tennis.repository.model.TennisPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TennisRepository extends JpaRepository<TennisPlayer, Long> {
}
