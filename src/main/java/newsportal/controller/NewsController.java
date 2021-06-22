package newsportal.controller;

import newsportal.entity.News;
import newsportal.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/newsportal/")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("")
    public String getNews(Model model) {
        System.out.println("news news ...");
        List<News> news = newsService.getNews();
        model.addAttribute("news", news);
        return "list-news";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        News theNews = new News();
        theModel.addAttribute("theNews", theNews);
        return "show-add-form";
    }

    @PostMapping("/saveNews")
    public String saveCustomer(@ModelAttribute("news") News theNews) {
        newsService.saveNews(theNews);
        return "redirect:/newsportal/";
    }

    @GetMapping("/delete")
    public String deleteNews(@RequestParam("newsId") Long theId) {
        newsService.deleteNewsById(theId);
        return "redirect:/newsportal/";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("newsId") Long theId,
                                    Model theModel) {
        News theNews = newsService.getNewsById(theId);
        theModel.addAttribute("news", theNews);
        return "news-form";
    }

}
