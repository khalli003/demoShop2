package com.example.demoshop.presentation.product.dto.commands;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UpdateProductCommand implements Serializable {
    @Past(message = "Товар не может быть создана в будущем")
    private LocalDateTime createdAt = LocalDateTime.now();
    @Length(message = "Название от 3 до 20 символов", min = 3, max = 20)
    private String title;
    @Positive(message = "Цена не может быть отрицательной")
    private Integer price;
}

