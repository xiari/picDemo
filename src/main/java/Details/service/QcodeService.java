package Details.service;

import Details.controller.request.QconRequestVo;
import Details.model.AccessTokenVo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static Details.utils.HttpUtil.get;
import static Details.utils.HttpUtil.post;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/19
 * Time: 14:48
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

@Service
public class QcodeService {

    @Autowired
    private ConfigService configService;

    public String getQcodeFromWx(){

//        String appId= "wxf40a810deaa95da8";
//        String secret= "7fc84d2b6f098b2afe64e4fbd8de1750";
//
//        String url="https://api.weixin.qq.com/cgi-bin/token";
//        wx.qcode.request.url="https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token="

        Map<String,String> paraMap = new HashMap<>();
        paraMap.put("grant_type", "client_credential");
        paraMap.put("appid", configService.appId);
        paraMap.put("secret", configService.appSecret);
        String jsonStr = get(configService.tokenRequestUrl, paraMap);
        AccessTokenVo tokenVo = JSON.parseObject(jsonStr, AccessTokenVo.class);

        QconRequestVo qconRequestVo = new QconRequestVo();
        qconRequestVo.setPath(configService.qCodeDefaultPage);
        qconRequestVo.setWidth(configService.qcodeSize);
        String requestPara = JSON.toJSONString(qconRequestVo);
//        String target = "D:/dev/PicDemo/qCon/";
        String token = tokenVo.getAccess_token();
        System.out.print("\n");
        System.out.print("<<<<<<<<<<<<<<<<token >>>>>>>>>>>>>>>>> is : " + token + "\n");
        return post(configService.qCodeRequestUrl+token,requestPara,configService.qCodePicLocation);
    }
}
