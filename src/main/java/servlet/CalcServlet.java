package servlet;

import controller.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/"}
)
public class CalcServlet extends HttpServlet {

    private Map<String, Controller> mapController;
    private Controller controller;

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        mapController = new HashMap<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ip = request.getRemoteAddr();
        if (mapController.containsKey(ip)) {
            controller = mapController.get(ip);
        } else {
            mapController.put(ip,new Controller());
            controller = mapController.get(ip);
        }

        String btn = request.getParameter("btn");

        if (btn != null)
            controller.handleOnAnyButtonClicked(btn);

        request.setAttribute("result", controller.getDisplay().toString());
        request.setAttribute("result2", controller.getDisplayBuffer().toString());
        request.getRequestDispatcher("calc.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
