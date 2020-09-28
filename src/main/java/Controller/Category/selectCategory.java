package Controller.Category;

import Log.Log4j;
import Model.Service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/category/selectCategory")
public class selectCategory extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("list", CategoryService.getInstance().selectCategory());
            req.getRequestDispatcher("/category.jsp").forward(req, resp);

        } catch (Exception e) {
            Log4j.getLogger().info("selectCategory have a exception");
        }

    }
}
