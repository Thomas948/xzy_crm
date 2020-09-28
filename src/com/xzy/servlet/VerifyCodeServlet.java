package com.xzy.servlet;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建验证码核心对象
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);

        //设置响应头
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        //生成验证码
        String kaptchaText = defaultKaptcha.createText();
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,kaptchaText);
        BufferedImage image = defaultKaptcha.createImage(kaptchaText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);

        out.flush();
        out.close();
    }
}
