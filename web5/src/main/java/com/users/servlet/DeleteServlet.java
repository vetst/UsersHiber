package com.users.servlet;

import com.users.service.UserService;
import com.users.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    UserService userService = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = null;
        userId = req.getParameter("userId");
        try {
            userService = UserServiceImpl.getInstance();
            Long id = Long.parseLong(userId);
            userService.deleteUser(id);
            resp.sendRedirect(req.getContextPath() + "/main");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
