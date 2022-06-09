package io.spring.core.history;

import io.spring.core.article.Article;
import io.spring.core.article.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor
public class History {

  @Id @GeneratedValue private Long id;

  @Enumerated(EnumType.STRING)
  private CommandType type;

  private String userId;
  private String articleId;
  private String title;
  private String slug;
  private String description;
  private String body;
  private String tags;

  @CreationTimestamp private final LocalDateTime occurredAt = LocalDateTime.now();

  public History(CommandType type, Article article) {
    this.type = type;
    this.articleId = article.getId();
    this.userId = article.getUserId();
    this.title = article.getTitle();
    this.slug = article.getSlug();
    this.description = article.getDescription();
    this.body = article.getBody();
    this.tags = article.getTags().stream().map(Tag::getName).collect(Collectors.joining(","));
  }
}
