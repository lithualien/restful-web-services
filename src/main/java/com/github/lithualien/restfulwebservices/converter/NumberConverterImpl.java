package com.github.lithualien.restfulwebservices.converter;

import com.github.lithualien.restfulwebservices.exceptions.UnsupportedSymbolException;
import org.springframework.stereotype.Component;

@Component
public class NumberConverterImpl implements NumberConverter {

    public Long stringToLong(String number) {
        try {
            return Long.parseLong(number);
        } catch (Exception e) {
            throw new UnsupportedSymbolException("Input contained illegal symbols.");
        }
    }

}
