package org.example.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    /**处理器方法返回String，表示逻辑视图名称，需要配置视图解析器*/

    @RequestMapping(value = "/returnString-view.do")
    public String doReturnView(HttpServletRequest request, String name,Integer age){
        System.out.println("doReturnView,name="+name+" age="+age);
        request.setAttribute("myname",name);
        request.setAttribute("myage",age);
        /**show 是逻辑视图名称，项目中配置了视图解析器*/
        return "show";
    }


/**
 *      return "WEB-INF/view/show.jsp";
 * 完整路径不能使用视图解析器，路径会冲突，可解决。
 * */



/**返回值Object*/
@RequestMapping (value = "/returnStudentJsonArray.do")
@ResponseBody
public List<Student> doStudentJsonArray(HttpServletResponse response, String name, Integer age) throws IOException {
    List<Student> list=new ArrayList<>();
    Student student =new Student();
    student.setName("zhangsan ");
    student.setAge(22);
    list.add(student);

   /* *把结果的对象转换为json格式*/
    String json="";
    if (student !=null){
        ObjectMapper om =new ObjectMapper();
        json= om.writeValueAsString(student);
        System.out.println("student转换为json格式"+json);
    }

   /* *输出数据，响应ajax请求*/
    response.setContentType("application/json;charset=utf-8");
    PrintWriter pm=response.getWriter();
    pm.println(json);
    pm.flush();
    pm.close();

    return null;
}
}


