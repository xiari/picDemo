package Details.service;

import Details.Mapper.UserInfoMapper;
import Details.Mapper.UserSessionMapper;
import Details.model.LoginStatusVo;
import Details.model.SessionVo;
import Details.model.UserSessionVo;
import Details.utils.FreshTrackingConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private LoginApiRequestService loginApiRequestService;

    @Autowired
    private UserSessionMapper sessionMapper;

    /**
     * 获取登录状态
     * @param loginCode
     * @return
     */
    public LoginStatusVo getUserLoginStatus(String loginCode){
        LoginStatusVo statusVo = new LoginStatusVo();
        UserSessionVo userSessionVo = loginApiRequestService.queryUserSessionInfo(loginCode);
        if(userSessionVo != null
                && userSessionVo.getSessionKey() != null
                && userSessionVo.getOpenId() != null){
            statusVo.setStatus(FreshTrackingConstant.LOGIN_ON);
        }
        // 记录数据到数据库（用户openId + sessionKey)
        if(sessionMapper.insertUserSessionInfo(userSessionVo) <= 0 ){
            logger.info("用户openId + sessionKey 数据库保存失败");
        }
        return  statusVo;
    }
}
