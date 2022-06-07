package io.spring.core.history;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;

import java.util.List;

import static io.spring.core.history.QHistory.history;

@AllArgsConstructor
public class HistoryRepositoryImpl implements HistoryRepositoryCustom {

    private final JPAQueryFactory factory;

    @Override
    public List<History> findHistoryByUserId(String userId, Long id, int limit) {

        BooleanBuilder dynamicLtId = new BooleanBuilder();
        if (id != 0L) {
            dynamicLtId.and(history.id.lt(id));
        }

        return factory
                .select(history)
                .from(history)
                .where(dynamicLtId
                        .and(history.userId.eq(userId)))
                .orderBy(history.id.desc())
                .limit(limit)
                .fetch();
    }

    @Override
    public int countHistoryByUserId(String userId) {
        return factory
                .select(history)
                .from(history)
                .where(history.userId.eq(userId)).fetch().size();
    }
}
