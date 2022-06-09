package io.spring.core.history;

import java.util.List;

public interface HistoryRepositoryCustom {
  List<History> findHistoryByUserId(String userId, int offset, int limit);

  int countHistoryByUserId(String userId);
}
