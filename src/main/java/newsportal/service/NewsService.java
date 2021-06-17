package newsportal.service;

import newsportal.entity.News;

import java.util.List;

public interface NewsService {
    List<News> getNews();
    News getNewsById(Long id);
    void saveNews(News news);
    void deleteNewsById(Long id);
}
