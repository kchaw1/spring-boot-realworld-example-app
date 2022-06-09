package io.spring.core.history;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;

import java.util.List;

import static io.spring.core.history.QHistory.history;

@AllArgsConstructor
public class HistoryRepositoryImpl implements HistoryRepositoryCustom {

  private final JPAQueryFactory factory;

  @Override
  public List<History> findHistoryByUserId(String userId, int offset, int limit) {
    return factory
        .select(history)
        .from(history)
        .where(history.userId.eq(userId))
        .orderBy(history.id.desc())
        .limit(limit)
        .offset(offset)
        .fetch();
  }

  @Override
  public int countHistoryByUserId(String userId) {
    return factory.select(history).from(history).where(history.userId.eq(userId)).fetch().size();
  }
}
