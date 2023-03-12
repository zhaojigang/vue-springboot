package io.study.vuespringboot.user;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户控制器
 *
 * @author zhaowang
 */
@Api("用户")
@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("login")
    public UserLoginDTO login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("logout")
    public void logout(@RequestBody String token) {
        userService.logout(token);
    }
}
