package com.erp.interceptor;
import  com.erp.pojo.User;
import com.erp.constant.ErpConstant;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @author : Du
 * @date : 2019/8/24 20:16
 * @description :
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      HttpSession session = request.getSession();
        User user = (User) session.getAttribute(ErpConstant.USER_IN_SESSION);
       if (user != null) {
            return true;
        } else {
            PrintWriter out = response.getWriter();
            out.println("<script>");
            out.println("window.open ('" + request.getContextPath() + "/l','_top')");
            out.println("</script>");
            return false;
        }

    }
}
