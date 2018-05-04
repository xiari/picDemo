package Details.Mapper;

import Details.model.UserInfoVo;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/19
 * Time: 14:12
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

public interface UserInfoMapper {

    UserInfoVo queryUserInfo(UserInfoVo userInfoVo);

    int insertUserInfo(UserInfoVo userInfoVo);
}
