package src.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import src.auth.service.AuthenticationService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author wangyaochong
 * @date 2020/3/23 14:06
 */
@RestController
@RequestMapping("userAuth")
@Slf4j
public class UserAuthController {

    @Resource
    AuthenticationService authenticationService;

    @PostMapping("login")
    public String login(AuthenticationRequest request, HttpSession session) {
        UserDto authentication = authenticationService.authentication(request);
        session.setAttribute("_user", authentication);
        session.setMaxInactiveInterval(10);
        System.out.println("用户登录成功，有效时间=" + session.getMaxInactiveInterval() + "秒");
        return authentication.getUsername() + " 登录成功";
    }

    @GetMapping("visit")
    public UserDto visit(HttpSession session) {
//        超过session的maxInactiveInterval，就无法获取到_user了。
        return (UserDto) session.getAttribute("_user");
    }

}
