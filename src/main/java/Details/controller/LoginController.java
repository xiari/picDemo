package Details.controller;

import Details.controller.request.SessionRequestVo;
import Details.controller.response.BaseResponse;
import Details.model.LoginStatusVo;
import Details.service.ConfigService;
import Details.service.LoginService;
import Details.utils.FreshTrackingConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/16
 * Time: 10:08
 * Desc:
 * 基于功能
 */

@RestController
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;
    @Autowired
    private ConfigService configService;

    @GetMapping(value ="login")
    public BaseResponse login(@RequestParam(value = "code") String code){
        BaseResponse<LoginStatusVo> baseResponse = new BaseResponse();
        if(StringUtils.isEmpty(code)){
            baseResponse.setResponseCode(FreshTrackingConstant.FAILED_CODE);
            baseResponse.setResponseMsg("查询code输入信息为空");

            return baseResponse;
        }
        SessionRequestVo requestVo = new SessionRequestVo();
        requestVo.setCode(code);
        requestVo.setAppId(configService.appId);
        requestVo.setAppSecretId(configService.appSecret);
        baseResponse.setT(loginService.getUserLoginStatus(code));
        return baseResponse;
    }
}
