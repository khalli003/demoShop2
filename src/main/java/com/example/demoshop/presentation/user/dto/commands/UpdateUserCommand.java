package com.example.demoshop.presentation.user.dto.commands;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateUserCommand {
    @Length(message = "Имя от 3 до 20 символов", min = 3, max = 20)
    public String name;
}
