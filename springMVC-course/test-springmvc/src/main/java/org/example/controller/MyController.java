package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**@Controller: 创建处理器对象，放在springmvc中*/
@Controller
public class MyController {
    //使用方法，处理请求
    /**@RequestMapping: 请求映射，作用是把一个请求地址和一个方法绑定一起。一个请求指定一个方法处理
     *      属性：value：String类型，表示请求的uri地址（some.do）。值唯一不可重复，使用时推荐地址"/"
     *
     *      返回值：ModelAndView 本次请求处理结果
     *          model：数据，请求处理完成显示给用户的数据
     *          view： 视图，例如jsp等
     *
     *          HttpServletRequest request,
     *          HttpServletResponse response,
     *          HttpSession session
     *          接收用户请求处理参数
     */
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(HttpServletRequest request,
                               HttpServletResponse response,
                               HttpSession session){
        /**应该调用service处理请求，此处简化*/
        ModelAndView mv = new ModelAndView();

        /**添加数据，框架在请求最后把数据放入到request作用域
         * request.setAttribute("")
         * */
        mv.addObject("msg","欢迎使用springmvc做web开发"+request.getParameter("name"));
        mv.addObject("fun","执行的是dosome方法");

        /**指定视图完整路径，框架对视图执行forWord操作，request。getRequestDispatcher("/show.jsp").foeword(...)*/
       // mv.setViewName("/WEB-INF/view/show.jsp");

        //配置视图解析器之后，使用逻辑名称（文件名），指定视图
        mv.setViewName("show");

        return mv;
    }
}
/**
 * springmvc请求的处理流程
 * 1)发起some.do
 * 2) tomcat(web.xml--url-pattern知道 *.do的请求给Di spatcherservlet)
 * 3) Dispatcherservlet (根据springmvc.xml配置知道some.do---doSome () )
 * 4) Dispatcherservlet 把some . do转发个MyController . dosome ()方法
 * 5)框架执行doSome ( )把得到ModelAndView进行处理，转 发到show. jsp
 *
 * 上面的过程简化的方式
 * some.do---DispatcherServlet---MyController
 * */
