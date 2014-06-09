package com.javapms.basic.jcaptcha;

import com.javapms.basic.utils.session.SessionProvider;
import com.octo.captcha.service.CaptchaServiceException;
import com.octo.captcha.service.image.ImageCaptchaService;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class JcaptchaServlet extends HttpServlet {
    public static final String CAPTCHA_IMAGE_FORMAT = "jpeg";
    private ImageCaptchaService captchaService;
    private SessionProvider session;

    public void init()
            throws ServletException {
        WebApplicationContext appCtx =
                WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        this.captchaService =
                ((ImageCaptchaService) BeanFactoryUtils.beanOfTypeIncludingAncestors(appCtx, ImageCaptchaService.class));
        this.session =
                ((SessionProvider) BeanFactoryUtils.beanOfTypeIncludingAncestors(appCtx, SessionProvider.class));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        byte[] captchaChallengeAsJpeg = (byte[]) null;

        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            String captchaId = this.session.getSessionId(request, response);
            BufferedImage challenge = this.captchaService.getImageChallengeForID(
                    captchaId, request.getLocale());

            ImageIO.write(challenge, "jpeg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            response.sendError(404);
            return;
        } catch (CaptchaServiceException e) {
            response.sendError(500);
            return;
        }
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();


        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0L);
        response.setContentType("image/jpeg");

        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.javapms.basic.jcaptcha.JcaptchaServlet

 * JD-Core Version:    0.7.0.1

 */