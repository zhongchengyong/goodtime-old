package com.mySSM.common.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;


public class JsonUtil {

    public static void success(HttpServletResponse response,Object object)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.print(object);
        out.flush();
        out.close();
    }
}