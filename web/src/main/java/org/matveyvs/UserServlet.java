package org.matveyvs;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private final transient UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        userService.createAllUsersAndWriteToJson();
        Optional<List<UserDto>> allUsers = userService.getAllUsers();
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        if (allUsers.isPresent()) {
            writer.write("<html><body>");
            writer.write("<h1> List of all users is </h1>");
            for (int i = 0; i < allUsers.get().size(); i++) {
                writer.write("<h3>User id: " + allUsers.get().get(i).getId() +
                        " User: " + allUsers.get().get(i).getName() +
                        " Company: " + allUsers.get().get(i).getCompany() + "</h3>");
            }
        }

        Long idToUpdate = 1L;
        Optional<UserDto> user = userService.getUser(idToUpdate);
        String nameToUpdate = "Oleg";

        if (user.isPresent()) {
            writer.write("<h1> User to update </h1>");
            writer.write("<h3>User id: " + user.get().getId() +
                    " User: " + user.get().getName() +
                    " Company: " + user.get().getCompany() + "</h3>");

            writer.write("<h1> Lets add new name: " + nameToUpdate + "</h1>");

            if (userService.updateUserAndWriteToJson(idToUpdate, nameToUpdate)) {
                Optional<UserDto> updatedUser = userService.getUser(idToUpdate);
                if (updatedUser.isPresent()) {
                    writer.write("<h1> Updated user </h1>");
                    writer.write("<h3>User id: " + updatedUser.get().getId() +
                            " User: " + updatedUser.get().getName() +
                            " Company: " + updatedUser.get().getCompany() + "</h3>");
                    writer.write("<h3>file.json was updated</h3>");
                }
            }
        }

        writer.write("</body></html>");
        writer.close();
    }
}
