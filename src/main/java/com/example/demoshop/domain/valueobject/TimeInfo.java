package com.example.demoshop.domain.valueobject;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class TimeInfo {
    @Column(name = "created_at", nullable = true)
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

}
