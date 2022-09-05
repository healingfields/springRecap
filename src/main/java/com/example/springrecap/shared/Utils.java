package com.example.springrecap.shared;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Utils {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHANUM = "AZAGFTIYUJMMBLGHPRWUEWajsdaurmzpoqmgkhljqwyr17593295032329";

    public String generateStringId(int length){
        StringBuilder stringBuilder = new StringBuilder(length);

        for(int i = 0; i<=length; i++){
            stringBuilder.append(ALPHANUM.charAt(RANDOM.nextInt(ALPHANUM.length())));
        }

        return new String(stringBuilder);
    }

}
