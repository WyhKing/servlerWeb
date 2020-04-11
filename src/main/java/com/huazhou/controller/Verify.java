package com.huazhou.controller;

import com.alibaba.fastjson.JSON;
import com.huazhou.util.ImageModel;
import com.huazhou.util.ImgUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/verify")
public class Verify extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        Map map = new HashMap<>();
        ImageModel imageModel = ImgUtil.createImgModel();
        map.put("codeKey", imageModel.getImgVal());
        map.put("codePic", imageModel.getBase64Str());
        printWriter.println(JSON.toJSONString(map));

    }
}
