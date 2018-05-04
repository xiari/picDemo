package Details.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/30
 * Time: 17:09
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

public class UserSessionVo implements Serializable{

    private static final long serialVersionUID = 38898546010783658L;

    @JSONField(name = "openid")
    private String openId;
    @JSONField(name="session_key")
    private String sessionKey;
//    private String unionId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
