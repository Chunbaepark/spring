package com.example.spring.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@ToString
@Service
@RequiredArgsConstructor
public class SampleService {

    @Autowired
    @Qualifier("dao1")
    private final SampleDAO sampleDAO;

//    @Qualifier("event")
//    private final SampleDAO sampleDAO2;
}
