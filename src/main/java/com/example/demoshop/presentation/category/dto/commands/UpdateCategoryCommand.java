package com.example.demoshop.presentation.category.dto.commands;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCategoryCommand {
    @NotBlank(message = "Название категории не должно быть пустым")
    public String name;
}

