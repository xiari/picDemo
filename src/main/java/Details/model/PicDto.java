package Details.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/19
 * Time: 13:42
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

public class PicDto implements Serializable{


    private static final long serialVersionUID = -1713638689918567040L;
    public String id ; // 图片id
    public String picName; // 图片名称
    public String seqNo; // 图片序号
    public String encodedUrl ; // 图片请求路径
    public String createTime ; // 图片传入时间（生成日期）
    public String updateTime ;  // 图片修改日期

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getEncodedUrl() {
        return encodedUrl;
    }

    public void setEncodedUrl(String encodedUrl) {
        this.encodedUrl = encodedUrl;
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
