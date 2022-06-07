package io.spring.api;

import io.spring.application.HistoryQueryService;
import io.spring.core.history.HistoryRepository;
import io.spring.core.service.AuthorizationService;
import io.spring.core.user.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
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
    //private AuthorizationService authorizationService;

    @GetMapping
    public ResponseEntity getHistory(
            @RequestParam(value = "id", defaultValue = "0") Long id,
            @RequestParam(value = "limit", defaultValue = "10") int limit,
            @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(
                historyQueryService.findHistoryByUserId(user.getId(), id, limit)
        );
    }
}
