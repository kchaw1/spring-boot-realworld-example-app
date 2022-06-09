package io.spring.application;

import io.spring.application.data.HistoryData;
import io.spring.application.data.HistoryDataList;
import io.spring.core.history.HistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HistoryQueryService {

  private HistoryRepository historyRepository;

  @Transactional
  public HistoryDataList findHistoryByUserId(String userId, int offset, int limit) {
    return new HistoryDataList(
        historyRepository.findHistoryByUserId(userId, offset, limit).stream()
            .map(
                history ->
                    new HistoryData(
                        history.getId(),
                        history.getArticleId(),
                        history.getTitle(),
                        history.getDescription(),
                        history.getBody(),
                        history.getOccurredAt(),
                        history.getType()))
            .collect(Collectors.toList()),
        historyRepository.countHistoryByUserId(userId));
  }
}
