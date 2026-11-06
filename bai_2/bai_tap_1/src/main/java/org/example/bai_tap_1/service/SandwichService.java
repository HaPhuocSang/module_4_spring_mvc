package org.example.bai_tap_1.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SandwichService implements ISandwichService {
    private final static Map<Integer, String> spiceList = new HashMap<>();
    static {
        spiceList.put(1, "Lettuce");
        spiceList.put(2, "Tomato");
        spiceList.put(3, "Mustard");
        spiceList.put(4, "Sprouts");
    }

    @Override
    public List<String> list() {
        return new ArrayList<>(spiceList.values());
    }
}
