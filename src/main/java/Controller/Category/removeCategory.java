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

@WebServlet("/category/removeCategory")
public class removeCategory extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Category category = new Category();
            category.setId(Integer.parseInt(req.getParameter("id")));
            CategoryService.getInstance().removeCategory(category);
            resp.sendRedirect("/category/selectCategory");

        } catch (Exception e) {
            Log4j.getLogger().info("deleteCategory have a exception");
        }

    }
}
