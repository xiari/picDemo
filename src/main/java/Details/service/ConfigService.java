package Details.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/19
 * Time: 14:48
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

@Service
public class ConfigService {

    @Value("${app.appId}")
    public static String appId;

    @Value("${app.secret}")
    public static String appSecret;

    @Value("${qCode.file.location}")
    public static String qCodePicLocation;

    @Value("${wx.access_token.request.url}")
    public static String tokenRequestUrl;

    @Value("${wx.qcode.request.url}")
    public static String qCodeRequestUrl;

    @Value("${qCode.DefaultPage}")
    public static String qCodeDefaultPage;

    @Value("${qCode.Size}")
    public static String qcodeSize;

    @Value("${wx.login.request.url}")
    public static String wxLoginRequestUrl;
}
