package newsportal.service;

import newsportal.entity.News;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    List<News> getNews();
    Optional<News> getNewsById(Long id);
    void saveNews(News news);
    void deleteNewsById(Long id);
}
