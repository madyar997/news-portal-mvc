package newsportal.service;

import newsportal.dao.NewsDao;
import newsportal.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    private NewsDao newsDao;

    @Override
    @Transactional
    public List<News> getNews() {
        return newsDao.getNews();
    }

    @Override
    public News getNewsById(Long id) {
        return newsDao.getNewsById(id);
    }

    @Override
    public void saveNews(News news) {
        newsDao.saveNews(news);
    }

    @Override
    public void deleteNewsById(Long id) {
        newsDao.deleteNewsById(id);
    }

}
