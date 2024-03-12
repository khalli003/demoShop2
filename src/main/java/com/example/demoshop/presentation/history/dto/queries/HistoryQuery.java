package com.example.demoshop.presentation.history.dto.queries;

import lombok.Data;

@Data
public class HistoryQuery {
    private Long id;
    private String action;
    private Long entityId;
}
