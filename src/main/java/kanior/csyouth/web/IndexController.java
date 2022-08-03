package kanior.csyouth.web;

import kanior.csyouth.web.argumentresolver.Login;
import kanior.csyouth.web.user.dto.LoginUserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(@Login LoginUserInfo userInfo, Model model) {
        if (userInfo != null) {
            model.addAttribute("userInfo", userInfo);
        }

        return "index";
    }
}
