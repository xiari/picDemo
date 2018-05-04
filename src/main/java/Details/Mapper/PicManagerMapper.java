package Details.Mapper;

import Details.model.PicVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/19
 * Time: 14:12
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

public interface PicManagerMapper {

    List<PicVo> getPicVoList(@Param(value= "seqNo") String seqNo);

    PicVo getPicVo(@Param(value= "name") String name ,@Param(value= "type") Integer type);

    int insertPicVo(PicVo picVo);
}
