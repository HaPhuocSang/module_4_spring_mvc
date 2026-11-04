package org.example.bai_tap_2.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "Xin chào");
        dictionary.put("book", "Quyển sách");
        dictionary.put("computer", "Máy tính");
        dictionary.put("apple", "Quả táo");
        dictionary.put("school", "Trường học");
        dictionary.put("student", "Học sinh");
        dictionary.put("teacher", "Giáo viên");
        dictionary.put("car", "Xe ô tô");
        dictionary.put("house", "Ngôi nhà");
        dictionary.put("beautiful", "Đẹp");
    }

    @Override
    public String findByWord(String word) {
        return dictionary.get(word);
    }
}
