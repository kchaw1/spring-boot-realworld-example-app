package io.spring.core.history;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findHistoryByUserId(String userId, Long id, int limit);
    int countHistoryByUserId(String userId);
}