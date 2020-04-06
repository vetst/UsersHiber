package com.users.util;

import com.users.dao.UserDao;
import com.users.dao.MySqlUserDao;
import com.users.dao.UserHibernateDAO;

public class UserDaoFactory {

    public static UserDao getUserDAO(String type) {
        if (type.equalsIgnoreCase("DaoJDBC")) {
            return new MySqlUserDao();
        } else {
            return new UserHibernateDAO();
        }
    }
}
