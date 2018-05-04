package Details.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/16
 * Time: 13:15
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

public class DateUtil {

    // 保存文件到指定路径
    public static String toDateStr(Date date){
        if(date == null){
            return null;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }


    public static void main(String[] args){

    }



}
