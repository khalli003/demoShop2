package com.example.demoshop.application.history;

import com.example.demoshop.domain.entity.History;
import com.example.demoshop.infrasrtucture.repositoty.HistoryRepository;
import com.example.demoshop.presentation.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;

    public List<History> getAll() {
        return historyRepository.findAll();
    }

    public History getById(Long id) {
        return historyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("History with id " + id + " not found"));
    }

    public History create(History historyFromCommand) {
        return historyRepository.save(historyFromCommand);
    }

    public History update(Long id, History historyFromCommand) {
        History history = getById(id);

        // Update history fields

        return historyRepository.save(history);
    }

    public void delete(Long id) {
        historyRepository.deleteById(id);
    }
}
