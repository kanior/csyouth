package kanior.csyouth.web.user;

import kanior.csyouth.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

//    @PostMapping("/user/auth")
//    public int auth(@Validated @RequestBody UserAuthRequestDto requestDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return -1;  // 입력 양식 오류
//        }
//
//        try {
//            Long id = userService.findByNameAndPhoneNumber(requestDto.getName(), requestDto.getPhoneNumber());
//            if (id == -1L) {
//                return 2;   // 이미 가입된 회원인 경우
//            }
//        } catch (IllegalArgumentException e) {
//            return 1;   // 청년부 명단에 없는 경우
//        }
//
//        return 0;   // 인증 성공
//    }

//    @PostMapping("/user/save")
//    public int save(@Validated @RequestBody UserSaveRequestDto requestDto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return -1;  // 입력 양식 오류
//        }
//
//        try {
//            Long id = userService.findByNameAndPhoneNumber(requestDto.getName(), requestDto.getPhoneNumber());
//            if (id == -1L) {
//                return 2;   // 이미 가입된 회원인 경우
//            }
//
//            userService.signUp(id, requestDto.getLoginId(), requestDto.getPassword());
//        } catch (IllegalArgumentException e) {
//            return 1;   // 청년부 명단에 없는 경우
//        }
//
//        return 0;
//    }
}
