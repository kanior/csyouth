package kanior.csyouth.web.user;

import kanior.csyouth.service.user.UserService;
import kanior.csyouth.web.user.dto.UserAuthForm;
import kanior.csyouth.web.user.dto.UserSaveForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
@Slf4j
public class UserController {

    private final UserService userService;
    private final HttpSession httpSession;

    @GetMapping("/user/auth")
    public String authForm(Model model) {
        model.addAttribute("auth", new UserAuthForm());
        return "user/authForm";
    }

    @PostMapping("/user/auth")
    public String auth(@Validated @ModelAttribute("auth") UserAuthForm form, BindingResult bindingResult, Model model) {

        if (form.getPhoneNumber() != null) {
            try {
                Integer.parseInt(form.getPhoneNumber());
            } catch (Exception e) {
//                log.info("number format exception = {}", bindingResult.getAllErrors());
//                bindingResult.rejectValue("phoneNumber", "");
            }
        }

        if (bindingResult.hasErrors()) {
            return "user/authForm";
        }

        try {
            Long id = userService.findByNameAndPhoneNumber(form.getName(), form.getPhoneNumber());
            if (id == -1L) {
                return "user/authForm";
            }
        } catch (IllegalArgumentException e) {
            return "user/authForm";
        }

        return "user/saveForm";
    }

//    @GetMapping("/user/save")
//    public String saveForm(Model model) {
//        model.addAttribute("user", new UserSaveForm());
//        return "user/saveForm";
//    }

    @PostMapping("/user/save")
    public String save(@Validated @ModelAttribute("user")UserSaveForm form, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "user/saveForm";
        }

        return "redirect:/";
    }

//    @GetMapping("/user/login")
//    public String userLogin() {
//        return "user/login";
//    }
}
