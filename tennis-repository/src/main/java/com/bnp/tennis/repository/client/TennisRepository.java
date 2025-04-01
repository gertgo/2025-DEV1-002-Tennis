package com.bnp.tennis.repository.client;

import com.bnp.tennis.repository.model.TennisGameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TennisRepository extends JpaRepository<TennisGameEntity, Long> {
}
