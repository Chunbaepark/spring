package com.example.spring.sample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("dao1")
public class SampleDAOImpl implements SampleDAO {
}
