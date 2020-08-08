ch03-return ：处理器方法的返回值表示请求处理结果

1、ModelAndView: 有数据和视图，对视图执行forward.
2、String : 表示视图，可以逻辑名称，也可以是完整视图路径
3、void ：不能表示数据，也不能表示视图
          在处理ajax时，可以使用void返回值。通过HttpServletResponse输出数据，响应ajax请求。
            ajax请求只有数据，没有视图。
4、Object :例如String,Integer,Map,List,Student等都是对象，对象有属性，属性就是数据。
            所以返回Object就是数据，和视图无关，可以使用对象表示的数据响应 ajax请求。

      做ajax，主要使用json的数据格式，步骤：
        1、加入处理json的工具库依赖，SpringMVC默认使用Jackson。
        2、在springmvc配置文件加入<mvc:annotation-driven>注解驱动
            json= om.writeValueAsString(Student);
        3、在处理器方法上加入@ResponseBody注解
            response.setContentType("application/json;charset=utf-8");
            PrintWriter pm=response.getWriter();
            pm.println(json);