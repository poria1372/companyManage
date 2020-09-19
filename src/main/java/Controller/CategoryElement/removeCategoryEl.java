package Controller.CategoryElement;

import Log.Log4j;
import Model.Entity.CategoryElement;
import Model.Service.CategoryElService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/categoryElement/removeCategoryElement")
public class removeCategoryEl extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            CategoryElement categoryElement = new CategoryElement();
            categoryElement.setId(Integer.parseInt(req.getParameter("id")));
            CategoryElService.getInstance().removeCategoryElement(categoryElement);
            resp.sendRedirect("/categoryElement/selectCategoryElement");

        } catch (Exception e) {
            Log4j.getLogger().info("removeCategoryElement have a exception");
        }

    }
}
