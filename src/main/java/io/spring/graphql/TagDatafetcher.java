package io.spring.graphql;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import io.spring.application.TagsQueryService;
import io.spring.graphql.DgsConstants.QUERY;
import lombok.AllArgsConstructor;

import java.util.List;

@DgsComponent
@AllArgsConstructor
public class TagDatafetcher {
  private TagsQueryService tagsQueryService;

  @DgsData(parentType = DgsConstants.QUERY_TYPE, field = QUERY.Tags)
  public List<String> getTags() {
    return tagsQueryService.allTags();
  }
}
