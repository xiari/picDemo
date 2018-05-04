package Details.controller;

import Details.config.WebAppConfig;
import Details.controller.response.BaseResponse;
import Details.service.PicService;
import Details.service.QcodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/16
 * Time: 10:08
 * Desc:
 * 基于功能 1:获取token 2: 获取图片流保存到本地，同时记录到
 */
@RestController
public class QcodeController {

    private final static Logger logger = LoggerFactory.getLogger(QcodeController.class);

    @Autowired
    public WebAppConfig webAppConfig;

    @Autowired
    public PicService picService;

    @Autowired
    public QcodeService qcodeService;

    @RequestMapping("/getQcodePic")
    public BaseResponse getQcodePic(){
        qcodeService.getQcodeFromWx();
        return new BaseResponse();
    }

}
