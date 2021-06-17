package newsportal.dao;

import newsportal.entity.News;

import java.util.List;

public interface NewsDao {
    List<News> getNews();
    News getNewsById(Long id);
    void deleteNewsById(Long id);
    void saveNews(News news);


}
