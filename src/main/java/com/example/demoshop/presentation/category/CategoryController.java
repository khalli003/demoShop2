package com.example.demoshop.presentation.category;

import com.example.demoshop.application.category.CategoryService;
import com.example.demoshop.domain.entity.Category;
import com.example.demoshop.presentation.category.dto.commands.CreateCategoryCommand;
import com.example.demoshop.presentation.category.dto.commands.UpdateCategoryCommand;
import com.example.demoshop.presentation.category.dto.queries.CategoryQuery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
class CategoryController {

    private CategoryService service;
    private ModelMapper modelMapper;

    @GetMapping
    public List<CategoryQuery> getAll() {
        return service.getAll().stream()
                .map(category -> modelMapper.map(category, CategoryQuery.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CategoryQuery getById(@PathVariable Long id) {
        return modelMapper.map(service.getById(id), CategoryQuery.class);
    }

    @PostMapping
    public CategoryQuery create(@RequestBody CreateCategoryCommand command) {
        Category categoryFromCommand = modelMapper.map(command, Category.class);

        Category category = service.create(categoryFromCommand);

        return modelMapper.map(category, CategoryQuery.class);
    }

    @PutMapping("/{id}")
    public CategoryQuery update(@PathVariable Long id, @RequestBody UpdateCategoryCommand command) {
        Category categoryFromCommand = modelMapper.map(command, Category.class);

        Category category = service.update(id, categoryFromCommand);

        return modelMapper.map(category, CategoryQuery.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
