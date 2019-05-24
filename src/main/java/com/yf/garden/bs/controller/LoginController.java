package com.yf.garden.bs.controller;

import com.yf.garden.bs.controller.login.model.VerifyCode;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建者 bee
 * 类名称
 * 类说明
 * 创建时间 2019/5/21
 */
@RestController
@RequestMapping("/api/bs/v1")
public class LoginController {
    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * 验证码
     *
     * @param
     * @return
     * @author bee
     * @date 2019/5/21 16:11
     */
    @RequestMapping("/getcode")
    public void getCode(HttpServletResponse response, HttpServletRequest request) throws Exception {
        // 1.根据随机数生成图片
        VerifyCode vc = new VerifyCode(60);//设置60秒过期
        /*ImageCode imageCode = createImageCode(request);*/
        // 2.将图片存入session中
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, vc);
        // 3.将生成的图片写入到接口响应中
        response.addHeader("Content-Type", "image/jpeg; charset=UTF-8");
        ImageIO.write(vc.getImage(), "JPEG", response.getOutputStream());
    }

}
