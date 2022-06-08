package io.spring.core.history;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findHistoryByUserId(String userId, int offset, int limit);
    int countHistoryByUserId(String userId);
}
