package com.lca.phx.interview.garage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GarageApp implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        GarageDriver.main(arg0); 
    }

}
