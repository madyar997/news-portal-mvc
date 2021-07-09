package newsportal.dao;

import newsportal.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NewsDao extends JpaRepository<News, Long> {
    void deleteById(Long id);
    Optional<News> findById(Long id);
}
