package io.spring.core.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

  List<History> findHistoryByUserId(String userId, int offset, int limit);

  int countHistoryByUserId(String userId);
}
