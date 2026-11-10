package org.example.bai_tap_1.service.language;

import org.example.bai_tap_1.enity.Languages;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LanguageService implements ILanguageService {
    private final static Map<Integer, Languages> languageMap = new HashMap<Integer, Languages>();
    static {
        languageMap.put(1, new Languages("en", "English"));
        languageMap.put(2, new Languages("vi", "Vietnamese"));
        languageMap.put(3, new Languages("ja", "Japanese"));
        languageMap.put(4, new Languages("zh", "Chinese"));
    }

    @Override
    public List<Languages> findALl() {
        return new ArrayList<>(languageMap.values());
    }
}
