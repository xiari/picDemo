package Details.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/16
 * Time: 13:15
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

public class DataEncryptUtil {

    // 保存文件到指定路径
    public static String encode4Utf8(String string){
        // 将application/x-www-from-urlencoded字符串转换成普通字符串
        try {
            return URLEncoder.encode(string,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 保存文件到指定路径
    public static String decode4Utf8(String string){
        // 将application/x-www-from-urlencoded字符串转换成普通字符串
        try {
            return URLDecoder.decode(string,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws UnsupportedEncodingException {
        String fileName = "屏幕截图(1) -. fad.副本.png";

        System.out.print(fileName.matches("[0-9]+"));
        System.out.print("121212".matches("[0-9]+"));


//        System.out.print( fileName + " -> " + UUID.randomUUID() + "."+ fileName.substring(fileName.lastIndexOf(".")+1) + "\n");
//
//        System.out.print( fileName + " -> " + UUID.randomUUID() + "."+ fileName.substring(fileName.lastIndexOf(".")+ 1) + "\n");
//        System.out.print( fileName + " -> " + URLEncoder.encode(fileName,"UTF-8") + "\n");
//        System.out.print(fileName + " -> " + URLDecoder.decode("%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%281%29+-+%E5%89%AF%E6%9C%AC","UTF-8") + "\n");
    }
}
