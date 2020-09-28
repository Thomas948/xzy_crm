package com.xzy.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/ImgGetServlet")
public class ImgGetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");

        FileInputStream fis = new FileInputStream("d:\\imgs\\"+fileName);

        OutputStream os = response.getOutputStream();

        byte[] bs = new byte[1024];
        int len;

        while((len=fis.read(bs))!=-1) {
            os.write(bs, 0, len);
        }
        fis.close();
    }
}
