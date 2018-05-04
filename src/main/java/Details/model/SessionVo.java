package Details.model;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/30
 * Time: 17:09
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

public class SessionVo {

    private String id;
    private String sessionKey;
    private String openId;

    private String createTime;
    private String updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
