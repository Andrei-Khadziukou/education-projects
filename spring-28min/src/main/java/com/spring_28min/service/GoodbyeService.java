package com.spring_28min.service;

import org.springframework.stereotype.Component;

/**
 * The implementation of {@link FarewellService} to say "Goodbye!".
 *
 * Created by andrei on 20.03.2016.
 */
@Component
public class GoodbyeService implements FarewellService {
    @Override
    public String farewell() {
        return "Goodbye!";
    }
}
