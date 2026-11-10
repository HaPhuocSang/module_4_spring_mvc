package org.example.bai_tap_1.service.page_size;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PageSizeService implements IPageSizeService{
    private final static Map<Integer, Integer> pageSizeMap = new HashMap<Integer, Integer>();
    static {
        pageSizeMap.put(1, 5);
        pageSizeMap.put(2, 10);
        pageSizeMap.put(3, 15);
        pageSizeMap.put(4, 25);
        pageSizeMap.put(5, 50);
        pageSizeMap.put(6, 100);
    }

    @Override
    public List<Integer> findALl() {
        return new ArrayList<>(pageSizeMap.values());
    }
}
