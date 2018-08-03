package com.htgy.userdao;

import com.htgy.user.User;
import org.springframework.jdbc.core.JdbcTemplate;

@SuppressWarnings("all")
public interface UserDao {
    public JdbcTemplate template = null;

    public User queryAccount(String account);

    public User queryUsername(String username);

    public void insert(String account, String password, String username);
}
