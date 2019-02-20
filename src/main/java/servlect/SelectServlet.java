package servlect;

import dao.Membersinfodao;
import emtity.Membersinfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by sunxiaolong on 2019-01-15.
 */
@WebServlet(name = "SelectServlet",urlPatterns = "/select")
public class SelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type=request.getParameter("type");
        Membersinfo membersinfo=new Membersinfo();
        Membersinfodao membersinfodao=new Membersinfodao();
        String message="";
        if(type==null) {

        }else if("u".equals(type)){
            Object mess= request.getAttribute("update");
            message=mess.toString();
        }
        List<Membersinfo> list= membersinfodao.selectAll();
        request.getSession().setAttribute("update",message);
        request.getSession().setAttribute("list",list);
        response.sendRedirect("Select.jsp");
}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
