package newsportal.service;

import newsportal.dao.NewsDao;
import newsportal.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
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
    @Transactional
    public News getNewsById(Long id) {
        return newsDao.getNewsById(id);
    }

    @Override
    @Transactional
    public void saveNews(News news) {
        news.setCreatedDate(new Date());
        newsDao.saveNews(news);
    }

    @Override
    @Transactional
    public void deleteNewsById(Long id) {
        newsDao.deleteNewsById(id);
    }

}
