package io.study.vuespringboot.user;

import lombok.Data;

/**
 * 用户模型
 *
 * @author zhaowang
 */
@Data
public class User {
    private String name;
    private String password;
}
