package Details.service;

import Details.model.UserSessionVo;
import Details.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/19
 * Time: 14:48
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

@Service
public class LoginApiRequestService {

    @Autowired
    private ConfigService configService;

    public UserSessionVo queryUserSessionInfo(String loginCode){
        // ?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
        Map<String ,String> paramMap = new HashMap<>();
        paramMap.put("appid",configService.appId);
        paramMap.put("secret",configService.appSecret);
        paramMap.put("js_code",loginCode);
        paramMap.put("grant_type","authorization_code");
        String sessionVoStr = HttpUtil.get(configService.wxLoginRequestUrl, paramMap);
        return JSON.parseObject(sessionVoStr, UserSessionVo.class);
    }
}
