package com.example.spring.sample;

import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("dao2")
//@Primary
public class SampleDAOImpl2 implements SampleDAO {
}
