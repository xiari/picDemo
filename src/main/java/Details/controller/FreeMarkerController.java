package Details.controller;

import Details.config.WebAppConfig;
import Details.model.PicVo;
import Details.service.PicService;
import Details.service.QcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/17
 * Time: 11:28
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class FreeMarkerController {

    @Autowired
    public WebAppConfig webAppConfig;

    @Autowired
    public PicService picService;

    @Autowired
    private QcodeService qcodeService;
    @RequestMapping("freeMarker")
    public String hello(Map<String,Object> map) {
        map.put("msg", "Hello Freemarker");
        return "index";
    }
    @GetMapping("picPath")
    public String picPath (@RequestParam(name="seqNo",required = true) String seqNo,
                         HttpServletRequest request, Model model){
        List<PicVo> picVoList = picService.getPicVoList(seqNo);
        model.addAttribute("picVoList", picVoList);
        return "list";
    }

    @GetMapping("qcodePicPath")
    public String qcodePicPath ( Model model){
        String url = qcodeService.getQcodeFromWx();
        model.addAttribute("url", url);
        return "qcode";
    }
}
