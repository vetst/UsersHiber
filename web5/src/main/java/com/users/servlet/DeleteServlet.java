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
    private String userId = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userId = req.getParameter("userId");
        String message = "Вы действительно хотите удалить пользователя ?";
        req.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/delete-user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = null;
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
