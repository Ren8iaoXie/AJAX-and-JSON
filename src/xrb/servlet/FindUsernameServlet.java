package xrb.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xieren8iao
 * @create 2019/3/24 - 17:15
 */
@WebServlet("/findUsernameServlet")
public class FindUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //记得设置返回的类型是json类型,
        // 如果不设置，可在服务器设置返回的类型response.setContentTyoe("application/json";charset=utf-8);
        response.setContentType("application/json;charset=utf-8");
        String username = request.getParameter("username");
        Map<String,Object> map=new HashMap<String, Object>();
        if("lucy".equals(username)){
            map.put("userExist", true);
            map.put("msg", "此用户名已被注册，请重新填写");
        }else{
            map.put("userExist", false);
            map.put("msg", "此用户名可用");
        }
        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getWriter(), map);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
