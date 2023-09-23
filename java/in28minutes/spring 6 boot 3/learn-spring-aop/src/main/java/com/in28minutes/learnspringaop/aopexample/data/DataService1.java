package com.in28minutes.learnspringaop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    public int[] retrieveData() {
        return new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    }

}
