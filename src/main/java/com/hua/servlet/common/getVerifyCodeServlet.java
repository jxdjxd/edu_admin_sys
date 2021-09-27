package com.hua.servlet.common;
import com.hua.jdbcutil.CodeUtil;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

/**
 * @author jxd
 * @date 2021/9/27 9:43
 */
@WebServlet("/getVerifyCode")
public class getVerifyCodeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ���ù��������ɵ���֤�����֤��ͼƬ
        Map<String, Object> codeMap = CodeUtil.generateCodeAndPic();

        // ����λ���ֵ���֤�뱣�浽Session��
        HttpSession session = req.getSession();
        System.out.println("java �����ɵ���֤�룺" + codeMap.get("code").toString());
        session.setAttribute("code", codeMap.get("code").toString());

        // ��ֹͼ�񻺴档
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", -1);

        resp.setContentType("image/jpeg");

        // ��ͼ�������Servlet������С�
        ServletOutputStream sos;
        try {
            sos = resp.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
            sos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
