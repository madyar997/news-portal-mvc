package newsportal.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String title;
    private Date createdDate;
    @Column(name = "text", columnDefinition = "TEXT")
    private String Text;

    public News() {

    }

    //TODO fix Text data type
    public News(String title, Date createdDate, String text) {
        this.title = title;
        this.createdDate = createdDate;
        Text = text;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(id, news.id) && Objects.equals(title, news.title) && Objects.equals(createdDate, news.createdDate) && Objects.equals(Text, news.Text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, createdDate, Text);
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createdDate=" + createdDate +
                ", Text='" + Text + '\'' +
                '}';
    }
}