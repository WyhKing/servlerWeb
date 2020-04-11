package com.huazhou.controller;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ghgjh");
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("");
        String pass = req.getParameter("password");

        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        Map<String, Object> map = new HashMap<>();
        map.put("name", username);
        map.put("pass", pass);
        map.put("result", "success");
        String resJSON = JSON.toJSONString(map);
        printWriter.println(resJSON);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
