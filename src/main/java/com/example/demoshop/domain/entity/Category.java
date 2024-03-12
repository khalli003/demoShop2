package com.example.demoshop.domain.entity;

import com.example.demoshop.domain.valueobject.BaseClass;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseClass {

    private String name;

}