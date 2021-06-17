package newsportal.controller;

import newsportal.entity.News;
import newsportal.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/newsportal")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/news")
    public String getNews(Model model) {
        System.out.println("news news ...");
        List<News> news = newsService.getNews();
        model.addAttribute("news", news);
        return "listNews";
    }


}
