package Controller.CategoryElement;

import Log.Log4j;
import Model.Service.CategoryElService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/categoryElement/selectCategoryElement")
public class selectCategoryEl extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("list", CategoryElService.getInstance().selectCategoryElement());
            req.getRequestDispatcher("/categoryElement.jsp").forward(req,resp);

        }catch (Exception e){
            Log4j.getLogger().info("selectCategoryElement have a exception");
        }

    }
}
