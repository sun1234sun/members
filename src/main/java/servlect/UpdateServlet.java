package servlect;

import dao.Membersinfodao;
import emtity.Membersinfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by sunxiaolong on 2019-01-15.
 */
@WebServlet(name = "UpdateServlet",urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Membersinfo membersinfo=new Membersinfo();
        Membersinfodao membersinfodao=new Membersinfodao();
        request.setCharacterEncoding("utf-8");
        String type=request.getParameter("type");
        if(type!=null && "sel".equals(type)){
            //查询
            sel(request,response);
        }else if(type!=null && "upd".equals(type)){
            //修改
            update(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
    public void sel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        Integer id=Integer.valueOf(request.getParameter("id"));
        System.out.println(id);
        Membersinfodao membersinfodao=new Membersinfodao();
        Membersinfo membersinfo=membersinfodao.selectId(id);
        request.getSession().setAttribute("info",membersinfo);
        response.sendRedirect("update.jsp");
        System.out.println(membersinfo.toString());
    }
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        Membersinfo membersinfo=new Membersinfo();
        Membersinfodao membersinfodao=new Membersinfodao();
        membersinfo.setMid(Integer.parseInt(request.getParameter("mid")));
        membersinfo.setMage(Integer.parseInt(request.getParameter("age")));
        membersinfo.setMaddress(request.getParameter("address"));
        membersinfo.setMemail(request.getParameter("email"));
        membersinfo.setMgender(request.getParameter("gender"));
        membersinfo.setMname(request.getParameter("name"));
        int x=membersinfodao.update(membersinfo);
        if(x==1){
            request.setAttribute("update","更新成功");
        }else{
            request.setAttribute("update","更新失败");
        }
        request.getRequestDispatcher("select?type=u").forward(request,response);
    }
}
