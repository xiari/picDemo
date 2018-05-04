package Details.Mapper;

import Details.model.SessionVo;
import Details.model.UserSessionVo;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/19
 * Time: 14:12
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

public interface UserSessionMapper {

    SessionVo queryUserInfo(UserSessionVo UserSessionVo);

    int insertUserSessionInfo(UserSessionVo UserSessionVo);
}
