package com.example;

import org.springframework.stereotype.Service;

@Service
public class SimpleService {
    @TimeIt
    public void serve() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }    
}
