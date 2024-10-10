package io.hhplus.concert.domain.service.concert;

import io.hhplus.concert.domain.repository.concert.ConcertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConcertService {

    private final ConcertRepository concertRepository;

}
