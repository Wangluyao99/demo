package org.example.controller;


import org.example.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MyController {

    /**逐个接收参数；
     *      要求；处理器方法的形参名和请求参数参数名一致
     *             同名请求参数赋值给同名的形参
     * */

    @RequestMapping(value = "/receiveproperty.do")
    public ModelAndView doSome(String name,Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }


    /**@RequestParam
     * 解决处理器方法的形参名和请求参数参数名，名称不一样的问题
     * */
    @RequestMapping(value = "/receiveparam.do")
    public ModelAndView receiveparam(@RequestParam("rname") String name,
                                     @RequestParam("rage")  Integer age){
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        mv.setViewName("show");
        return mv;
    }

    /**处理器方法形参是Java对象，对象的属性名和请求参数名一样
     *  框架会创建形参的Java对象，给属性赋值。请求参数是name，调用setName()
     * */
    @RequestMapping(value = "/receiveobject.do")
    public ModelAndView doSome(Student myStudent){
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",myStudent.getName());
        mv.addObject("myage",myStudent.getAge());
        mv.setViewName("show");
        return mv;
    }
}

