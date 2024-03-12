package com.example.demoshop.presentation.history.dto.commands;

import lombok.Data;

@Data
public class CreateHistoryCommand {
    private String action;
    private Long entityId;
}
