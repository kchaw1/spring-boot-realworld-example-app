package io.spring.infrastructure.jpa.repository;

import io.spring.infrastructure.jpa.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
}
