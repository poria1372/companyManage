package Controller.Category;

import Log.Log4j;
import Model.Entity.Category;
import Model.Service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/category/insertCategory")
public class insertCategory extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Category category = new Category();
            category.setName(req.getParameter("name"));
            category.setCode(Integer.parseInt(req.getParameter("code")));
            CategoryService.getInstance().insertCategory(category);
            resp.sendRedirect("/category/selectCategory");

        } catch (IOException e) {
            e.printStackTrace();
            Log4j.getLogger().info("insertCategory have a exception");

        }
    }
}
