package com.example.demoshop.infrasrtucture.repositoty;

import com.example.demoshop.domain.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

}
