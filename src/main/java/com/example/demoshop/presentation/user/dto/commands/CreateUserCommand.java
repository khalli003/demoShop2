package com.example.demoshop.presentation.user.dto.commands;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CreateUserCommand {
    @Length(message = "Имя от 3 до 20 символов", min = 3, max = 20)
    public String name;
}