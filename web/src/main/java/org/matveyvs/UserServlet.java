package org.matveyvs;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Optional<UserDto> user = userService.getUser(1L);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write("<html><body>");
        writer.write("<h1> User: " + user.get().getName() + "</h1>");
        writer.write("<h2> Company: " + user.get().getCompany() + "</h2>");
        writer.write("</body></html>");
        writer.close();
    }
}
