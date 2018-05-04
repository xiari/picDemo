package Details.controller.request;


import java.io.Serializable;

public class SessionRequestVo implements Serializable {

    private static final long serialVersionUID = 5442695019492691420L;

    private String  code;
    private String appId;
    private String appSecretId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecretId() {
        return appSecretId;
    }

    public void setAppSecretId(String appSecretId) {
        this.appSecretId = appSecretId;
    }
}
