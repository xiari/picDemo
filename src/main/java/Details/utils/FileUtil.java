package Details.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/16
 * Time: 13:15
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

public class FileUtil {

    // 保存文件到指定路径
    public static String saveFile(MultipartFile multipartFile, String path, String newFullName) throws Exception{
        // outPath
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(path + File.separator + newFullName));

        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        byte[] bs = new byte[1024];
        int len ;

        while((len = fileInputStream.read(bs)) != -1){
            bos.write(bs, 0,len);
        }
        bos.flush();
        bos.close();
        return multipartFile.getOriginalFilename();
    }

    // 保存文件到指定路径,覆盖原有的图片,返回存储路径
    public static String saveImageToByInputStream(InputStream inputStream, String path) throws Exception{
        // outPath
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        String imageName = "appQcon" + ".jpg";
        String filePath = path + imageName;
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(filePath));
        byte[] bs = new byte[1024];
        int len ;

        while((len = inputStream.read(bs)) != -1){
            bos.write(bs, 0,len);
        }
        inputStream.close();
        bos.flush();
        bos.close();
        System.out.print(">>>>>>>>>>>>>>>>>>> saveImageToByInputStream <<<<<<<<<<<<<<<<<<<<<<" + imageName);
        return imageName;
    }

    // 获取指定序列号对应的文件列表

    public static File[] getFileListByPath(String parentPath){
        File[] fileList = null;
        File file = new File(parentPath);
        if(file.isDirectory()){
            fileList = file.listFiles();
            for (int i = 0; i < fileList.length ; i++) {
                System.out.print(fileList[i].getName());
            }
        }
        return fileList;
    }


    public static void main(String[] args){

        System.out.print(UUID.randomUUID().toString());
//        getFileListByPath("");
    }



}
