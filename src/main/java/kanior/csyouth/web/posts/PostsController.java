package kanior.csyouth.web.posts;

import kanior.csyouth.service.posts.PostsService;
import kanior.csyouth.web.posts.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class PostsController {

    private final PostsService postsService;


    @GetMapping("/posts")
    public String postsList(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "posts/list";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts/save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto responseDto = postsService.findById(id);
        model.addAttribute("post", responseDto);
        return "posts/update";
    }
}
