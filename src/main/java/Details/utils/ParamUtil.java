package Details.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/16
 * Time: 13:15
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

public class ParamUtil {

    // 校验为数字格式字符串
    public static boolean isNumber(String string){
        return string.matches("[0-9]+");
    }
}
