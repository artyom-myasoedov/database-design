package courses.backend.service.model;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
public interface PageDto<T> {

  static PageDto<?> empty() {
    return ImmutablePageDto
      .builder()
      .items(List.of())
      .pageNumber(0)
      .totalPages(0)
      .build();
  }

  List<T> getItems();

  int getPageNumber();

  int getTotalPages();
}
