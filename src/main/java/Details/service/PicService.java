package Details.service;

import Details.Mapper.PicManagerMapper;
import Details.model.PicVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/19
 * Time: 14:48
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

@Service
public class PicService {

    @Autowired
    PicManagerMapper picManagerMapper;

    public List<PicVo> getPicVoList(String seqNo){
        return picManagerMapper.getPicVoList(seqNo);
    }

    public PicVo getPicVo(String name,Integer type){
        return picManagerMapper.getPicVo(name, Integer.valueOf(type));
    }

    public int insertPicVoList(List<PicVo> list){
        int result = 0;
        if(list == null){
            return -1;
        }
        for (PicVo vo : list
             ) {
            result += picManagerMapper.insertPicVo(vo);
        }
        return result;
    }

    public int insertPicVo( PicVo picVo){
        if(picVo == null){
            return -1;
        }
        return picManagerMapper.insertPicVo(picVo);
    }
}
