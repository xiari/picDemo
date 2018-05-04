package Details.controller.request;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/16
 * Time: 11:33
 * Desc:
 * 对于用户提交的数据，
 * 第一阶段只保存图片到本地，实现基本功能（即上传、下载、展示）
 * 第二阶段：考虑添加辅助信息到数据，包括获取用户微信id，用户点赞行为数据，该阶段需要进行增加数据库
 */

public class UploadRequestVo {

    public String creator;

    public String date; // 扩展字段，暂时不用

    public String seqNo; // 图片编号

    public MultipartFile multipartFile; // 图片文件

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
