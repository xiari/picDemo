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

public class PicVo implements Serializable{

    private static final long serialVersionUID = 8586141320583174935L;

    public String id ; // 图片id
    public String picName; // 图片名称
    public String seqNo; // 图片序号
    public String picQueryUrl ; // 图片请求路径
    public String encodedUrl ; // 编码后路径
    public Date createTime ; // 图片传入时间（生成日期）
    public Integer type;
    public Date updateTime ;  // 图片修改日期

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getPicQueryUrl() {
        return picQueryUrl;
    }

    public void setPicQueryUrl(String picQueryUrl) {
        this.picQueryUrl = picQueryUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getEncodedUrl() {
        return encodedUrl;
    }

    public void setEncodedUrl(String encodedUrl) {
        this.encodedUrl = encodedUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PicVo{" +
                "id='" + id + '\'' +
                ", picName='" + picName + '\'' +
                ", seqNo='" + seqNo + '\'' +
                ", picQueryUrl='" + picQueryUrl + '\'' +
                ", encodedUrl='" + encodedUrl + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
