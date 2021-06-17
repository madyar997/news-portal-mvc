package newsportal.dao;

import newsportal.entity.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class NewsDaoImpl implements NewsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<News> getNews() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<News> cq = cb.createQuery(News.class);
        Root<News> root = cq.from(News.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public News getNewsById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        News news = session.get(News.class, id);
        return news;
    }

    @Override
    public void deleteNewsById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        News news =  session.byId(News.class).load(id);
        session.delete(news);
    }

    @Override
    public void saveNews(News news) {
        Session session =  sessionFactory.getCurrentSession();
        session.saveOrUpdate(news);
    }

}
