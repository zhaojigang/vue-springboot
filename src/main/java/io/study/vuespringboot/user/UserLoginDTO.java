package io.study.vuespringboot.user;

import lombok.Builder;
import lombok.Data;

/**
 * 用户登录返回消息
 *
 * @author zhaowang
 */
@Builder
@Data
public class UserLoginDTO {
    private String name;
    private String token;
}
