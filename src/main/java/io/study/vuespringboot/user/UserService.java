package io.study.vuespringboot.user;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 用户服务
 *
 * @author zhaowang
 */
@Service
public class UserService {
    public static final Map<String, String> tokenMap = new HashMap<>();

    /**
     * 登录
     * 仅用作示例
     *
     * @param user
     * @return
     */
    public UserLoginDTO login(User user) {
        if (!"admin".equals(user.getName()) || !"123456".equals(user.getPassword())) {
            return null;
        }
        String token = user.getName() + "##vue-springboot-test-token" + UUID.randomUUID();
        tokenMap.put(user.getName(), token);
        return UserLoginDTO.builder().name(user.getName()).token(token).build();
    }

    public void logout(String token) {
        tokenMap.remove(token.split("##")[0]);
    }

    public static boolean permit(String userName, String token) {
        return token.equals(tokenMap.get(userName));
    }
}
