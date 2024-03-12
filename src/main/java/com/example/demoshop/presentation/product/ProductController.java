package com.example.shopproject.presentation.product;

import com.example.demoshop.application.category.CategoryService;
import com.example.demoshop.application.product.ProductService;
import com.example.demoshop.domain.entity.Category;
import com.example.demoshop.domain.entity.Product;
import com.example.demoshop.presentation.product.dto.commands.CreateProductCommand;
import com.example.demoshop.presentation.product.dto.commands.UpdateProductCommand;
import com.example.demoshop.presentation.product.dto.queries.ProductQuery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
class ProductController {

    private ProductService service;
    private ModelMapper modelMapper;
    private CategoryService categoryService;

    @GetMapping
    public List<ProductQuery> getAll() {
        return service.getAll().stream()
                .map(product -> modelMapper.map(product, ProductQuery.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductQuery getById(@PathVariable Long id) {
        return modelMapper.map(service.getById(id), ProductQuery.class);
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductQuery> getByCategory(@PathVariable Long categoryId) {
        Category category = categoryService.getById(categoryId);
        return service.getByCategory(category).stream()
                .map(product -> modelMapper.map(product, ProductQuery.class))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ProductQuery create(@RequestBody CreateProductCommand command) {
        Product productFromCommand = modelMapper.map(command, Product.class);

        Product product = service.create(productFromCommand);

        return modelMapper.map(product, ProductQuery.class);
    }

    @PutMapping("/{id}")
    public ProductQuery update(@PathVariable Long id, @RequestBody UpdateProductCommand command) {
        Product productFromCommand = modelMapper.map(command, Product.class);

        Product product = service.update(id, productFromCommand);

        return modelMapper.map(product, ProductQuery.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

