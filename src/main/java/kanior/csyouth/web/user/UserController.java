package kanior.csyouth.web.user;

import kanior.csyouth.service.user.UserService;
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

    @GetMapping("/user/save")
    public String saveForm(Model model) {
        model.addAttribute("user", new UserSaveForm());
        return "user/saveForm";
    }

    @PostMapping("/user/save")
    public String save(@Validated @ModelAttribute("user") UserSaveForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.error("회원 가입 양식 오류={}", bindingResult.getAllErrors());
            return "user/saveForm";
        }

        //아이디 중복 검사
        if (userService.isLoginIdDuplicated(form.getLoginId())) {
            bindingResult.rejectValue("loginId", "NotDuplicated");
            return "user/saveForm";
        }

        //패스워드 검사
        if (!form.getPassword().equals(form.getPasswordCheck())) {
            bindingResult.rejectValue("passwordCheck", "Equal");
            return "user/saveForm";
        }

        //이름 및 휴대폰 번호 중복 검사
        if (userService.isNameAndPhoneNumberDuplicated(form.getName(), form.getPhoneNumber())) {
            bindingResult.reject("DuplicatedUserCheck");
            return "user/saveForm";
        }

        userService.save(form);

//        return "user/welcome";
        return "redirect:/";
    }

}
