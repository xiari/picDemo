package Details.controller.response;

import static Details.utils.FreshTrackingConstant.SUCCESS_CODE;
import static Details.utils.FreshTrackingConstant.SUCCESS_MSG;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/16
 * Time: 11:07
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

public class BaseResponse<T>{

    public String responseCode = SUCCESS_CODE; // 默认成功

    public String responseMsg = SUCCESS_MSG;

    public T t;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
