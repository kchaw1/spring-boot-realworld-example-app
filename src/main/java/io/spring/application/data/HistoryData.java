package io.spring.application.data;

import io.spring.core.history.CommandType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryData {

  private Long id;
  private String articleId;
  private String title;
  private String description;
  private String body;
  private LocalDateTime occurredAt;
  private CommandType type;
}
