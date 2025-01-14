package io.spring.api;

import io.spring.application.HistoryQueryService;
import io.spring.core.user.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/history")
@AllArgsConstructor
public class HistoryApi {

  private HistoryQueryService historyQueryService;

  @GetMapping
  public ResponseEntity getHistory(
      @RequestParam(value = "offset", defaultValue = "0") int offset,
      @RequestParam(value = "limit", defaultValue = "10") int limit,
      @AuthenticationPrincipal User user) {
    return ResponseEntity.ok(historyQueryService.findHistoryByUserId(user.getId(), offset, limit));
  }
}
