package com.calc.history;

import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    private final List<String> history = new ArrayList<>();

    public void addRecord(String record) {
        history.add(record);
    }

    public List<String> getHistory() {
        return history;
    }
}
