package com.bit.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @RequestMapping("/hello")
    @ResponseBody
    public String alphaTest(){
        return "Hello Spring Boot.";
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        // 获取请求数据
        System.out.println(request.getMethod());  // 请求方式
        System.out.println(request.getServletPath());  // 请求路径
        Enumeration<String> headerNames = request.getHeaderNames(); // 请求的相关参数进行打印
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+":" + value);
        }
        // 返回code代码状态，没有状态返回null
        System.out.println(request.getParameter("code"));
        // 返回响应数据
        response.setContentType("text/html;charset=utf-8");
        try (            PrintWriter writer = response.getWriter();
        ){
            writer.write("<h1>牛客网<h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 之前的请求所有的访问都能访问，这里我们希望只能接受get请求的访问
     * @return
     */
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String selectStudent(
            @RequestParam(name="current", required = false, defaultValue = "1") int current,
            @RequestParam(name="limit", required = false, defaultValue = "31") int limit){
        System.out.println(current+":"+limit);
        return "some student";
    }

    /**
     * 这种方法的参数不是通过？加&的方法传入的而是直接在url表明的
     * @param id
     * @param name
     * @return
     */
    @RequestMapping(path = "/student/{id}/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id, @PathVariable("name") String name){
        System.out.println("id: "+id);
        System.out.println("name: "+name);
        return "get student";
    }

    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String getPostStudent(String name, int age){
        System.out.println("name:"+name);
        System.out.println("age:"+name);
        return "rsv student info";
    }

    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView returnTeacher(){
        ModelAndView view = new ModelAndView();
        view.addObject("name", "张三");
        view.addObject("age", "18");
        view.setViewName("/demo/view");
        return view;
    }

    @RequestMapping(path="/school", method = RequestMethod.GET)
    public String returnSchool(Model model){
        model.addAttribute("name", "BIT");
        model.addAttribute("age", "81");
        return "/demo/view";
    }

    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 18);
        map.put("salary", 8000);
        // {"name":"张三","salary":8000,"age":18}
        return map;
    }

    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps(){
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 18);
        map.put("salary", 8000);
        list.add(map);

        map = new HashMap<>();
        map.put("name", "王五");
        map.put("age", 23);
        map.put("salary", 18000);
        list.add(map);
        // [{"name":"张三","salary":8000,"age":18},
        // {"name":"王五","salary":18000,"age":23}]
        return list;
    }

}
