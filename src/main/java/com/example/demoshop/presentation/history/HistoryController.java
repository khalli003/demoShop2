package com.example.demoshop.presentation.history;

import com.example.demoshop.application.history.HistoryService;
import com.example.demoshop.domain.entity.History;
import com.example.demoshop.presentation.history.dto.commands.CreateHistoryCommand;
import com.example.demoshop.presentation.history.dto.commands.UpdateHistoryCommand;
import com.example.demoshop.presentation.history.dto.queries.HistoryQuery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/histories")
@AllArgsConstructor
class HistoryController {

    private HistoryService historyService;
    private ModelMapper modelMapper;

    @GetMapping
    public List<HistoryQuery> getAll() {
        return historyService.getAll().stream()
                .map(history -> modelMapper.map(history, HistoryQuery.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public HistoryQuery getById(@PathVariable Long id) {
        return modelMapper.map(historyService.getById(id), HistoryQuery.class);
    }

    @PostMapping
    public HistoryQuery create(@RequestBody CreateHistoryCommand command) {
        History historyFromCommand = modelMapper.map(command, History.class);

        History history = historyService.create(historyFromCommand);

        return modelMapper.map(history, HistoryQuery.class);
    }

    @PutMapping("/{id}")
    public HistoryQuery update(@PathVariable Long id, @RequestBody UpdateHistoryCommand command) {
        History historyFromCommand = modelMapper.map(command, History.class);

        History history = historyService.update(id, historyFromCommand);

        return modelMapper.map(history, HistoryQuery.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        historyService.delete(id);
    }
}
