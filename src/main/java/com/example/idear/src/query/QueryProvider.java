package com.example.idear.src.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryProvider {
    private final QueryRepository queryRepository;
}
