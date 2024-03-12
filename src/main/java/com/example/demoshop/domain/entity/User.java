package com.example.demoshop.domain.entity;

import com.example.demoshop.domain.valueobject.BaseClass;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseClass {

    private String name;

}

