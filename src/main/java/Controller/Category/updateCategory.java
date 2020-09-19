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

@WebServlet("/category/updateCategory")
public class updateCategory extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Category category = new Category();
            category.setName(req.getParameter("name"));
            category.setCode(Integer.parseInt(req.getParameter("code")));
            category.setId(Integer.parseInt(req.getParameter("id")));
            CategoryService.getInstance().updateCategory(category);
            resp.sendRedirect("/category/selectCategory");

        } catch (Exception e) {
            Log4j.getLogger().info("updateCategory have a exception");
        }
    }
}
