package com.users.servlet;

import com.users.exception.DBException;
import com.users.service.UserService;
import com.users.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    UserService userService = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userId = null;
        userId = req.getParameter("userId");
        req.setAttribute("userId", userId);
        String name = req.getParameter("name");
        String surName = req.getParameter("surName");
        if (name == null && surName == null) {
            getServletContext().getRequestDispatcher("/edit-user.jsp").forward(req, resp);
        }
        try {
            userService = UserServiceImpl.getInstance();
            Long id = Long.parseLong(userId);
            userService.updateUser(id, name, surName);
            resp.sendRedirect(req.getContextPath() + "/main");
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}
