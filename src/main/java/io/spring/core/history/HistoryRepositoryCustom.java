package io.spring.core.history;

import java.util.List;

public interface HistoryRepositoryCustom {
    List<History> findHistoryByUserId(String userId, Long id, int limit);
    int countHistoryByUserId(String userId);
}
