package com.htgy.userdao.impl;

import com.htgy.user.User;
import com.htgy.userdao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository("dao")
public class UserDAOImpl implements UserDao {
   @Resource
    private JdbcTemplate template;

   @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public User queryAccount(String account) {
       System.out.println("this is queryAccount"+"  "+ account);
               User user = (User)this.template.queryForObject(
                       "SELECT account, password FROM user WHERE account=?",
                       new Object[]{account},
                       new RowMapper() {
                           public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                               User user = new User();
                               user.setAccount(rs.getString("account"));
                               user.setPassword(rs.getString("password"));
                               return user;
                           }
                       });
       return user;
    }

    @Override
    public User queryUsername(String username) {
        return null;
    }

    @Override
    public void insert(String account, String password, String username) {

    }
}
