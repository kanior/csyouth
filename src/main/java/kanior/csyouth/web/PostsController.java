package kanior.csyouth.web;

import kanior.csyouth.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PostsController {

    private final PostsService postsService;


    @GetMapping("/posts")
    public String postsList(Model model) {

        return "";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate() {

        return "";
    }
}
