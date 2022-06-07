package io.spring.application;

import io.spring.application.data.HistoryData;
import io.spring.application.data.HistoryDataList;
import io.spring.core.history.History;
import io.spring.core.history.HistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HistoryQueryService {

    private HistoryRepository historyRepository;

    @Transactional
    public HistoryDataList findHistoryByUserId(String userId, Long id, int limit) {
        List<History> histories;
        histories = historyRepository.findHistoryByUserId(userId, id, limit);

        return new HistoryDataList(
                histories
                .stream()
                .map(history ->
                        new HistoryData(
                                history.getId(),
                                history.getArticleId(),
                                history.getUserId(),
                                history.getTitle(),
                                history.getOccurredAt(),
                                history.getType()))
                .collect(Collectors.toList()),
                historyRepository.countHistoryByUserId(userId));
    }
}
