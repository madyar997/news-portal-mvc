package newsportal.controller;

import newsportal.entity.News;
import newsportal.service.NewsService;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/newsportal")
public class NewsController {

//    static Logger log = Logger.getLogger(NewsController.class.getName());

    @Autowired
    private NewsService newsService;

    @GetMapping({"/",""})
    public String getNews(Model model) {
        System.out.println("news news ...");
//        log.info("inside the NewsController getNews method");
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
        Optional<News> theNews = newsService.getNewsById(theId);
        theModel.addAttribute("news", theNews);
        return "news-form";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

}
