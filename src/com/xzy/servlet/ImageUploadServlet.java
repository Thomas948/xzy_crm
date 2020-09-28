package com.xzy.servlet;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@WebServlet("/ImageUploadServlet")
public class ImageUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);


        try {
            List<FileItem> list = fileUpload.parseRequest(request);

            List<String> names = new ArrayList<>();
            for (FileItem fileItem : list) {
                String prefix = fileItem.getName().substring(fileItem.getName().lastIndexOf("."));

                String newName = String.valueOf(System.currentTimeMillis()).concat(UUID.randomUUID().toString()).concat(prefix);

                InputStream is = fileItem.getInputStream();

                FileOutputStream fos = new FileOutputStream("d:\\imgs\\"+newName);

                byte[] bs = new byte[1024];
                int len;
                while((len=is.read(bs))!=-1) {
                    fos.write(bs, 0, len);
                }
                fos.close();

                names.add(request.getContextPath()+"/ImgGetServlet?fileName="+newName); //将生成的文件名返回给客户端
                //names.add("http://localhost:8090/CRM_war_exploded/ImgGetServlet?fileName="+newName); //将生成的文件名返回给客户端
            }

            Map<String, Object> map = new HashMap<>();
            map.put("data", names);
            map.put("error", 0);

            String json = JSONObject.toJSONString(map);

            response.setHeader("Access-Control-Allow-Origin", "*");

            response.getOutputStream().write(json.getBytes());
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Request-Method", "post");

        resp.setHeader("Access-Control-Max-Age", "1728000");

    }
}
