package com.example.tennis;

import com.bnp.tennis.repository.client.TennisRepository;
import com.example.tennis.service.api.TennisService;
import org.springframework.stereotype.Service;

@Service
public class TennisServiceImpl implements TennisService {

    private TennisRepository tennisRepository;

    public TennisServiceImpl(TennisRepository tennisRepository) {
        this.tennisRepository = tennisRepository;
    }

    @Override
    public Long createGame() {
        return null;
    }
}
