package Details.controller;

import Details.config.WebAppConfig;
import Details.controller.response.BaseResponse;
import Details.model.PicDto;
import Details.model.PicVo;
import Details.service.PicService;
import Details.utils.FileUtil;
import Details.utils.ParamUtil;
import Details.utils.FreshTrackingConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static Details.utils.DateUtil.toDateStr;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/16
 * Time: 10:08
 * Desc:
 * 基于功能
 */

@RestController
public class PicController {

    private final static Logger logger = LoggerFactory.getLogger(PicController.class);

    @Autowired
    public WebAppConfig webAppConfig;

    @Autowired
    public PicService picService;

    @RequestMapping("/hello")
    public String hello(@RequestParam(name = "userName") String userName){
        System.out.print("hello " + userName);
        return userName;
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public BaseResponse updatePicList(@RequestParam(name = "multipartFile") MultipartFile multipartFile,
                                      @RequestParam(name = "seqNo" ,required = false) String seqNo){
        // 返回数据
        BaseResponse response = new BaseResponse();
        response.setResponseCode(FreshTrackingConstant.SUCCESS_CODE);
        response.setResponseMsg(FreshTrackingConstant.SUCCESS_MSG);

        // 校验
        if(multipartFile == null || StringUtils.isEmpty(multipartFile.getOriginalFilename() )) {
            response.setResponseCode(FreshTrackingConstant.FAILED_CODE);
            response.setResponseMsg("图片为空，请重新选择,谢谢");
            return response;
        }

        if(StringUtils.isEmpty(seqNo) ) {
            response.setResponseCode(FreshTrackingConstant.FAILED_CODE);
            response.setResponseMsg("序号为空，请重新输入,谢谢");
            return response;
        }
        //
        if(!ParamUtil.isNumber(seqNo)){
            response.setResponseCode(FreshTrackingConstant.FAILED_CODE);
            response.setResponseMsg("输入序列号非数字格式，请重新输入,谢谢");
            return response;
        }

        String contentType = multipartFile.getContentType();
        // 读取上传文件参数
        String originalFilename = multipartFile.getOriginalFilename();
        logger.info("上传图片:name={},type={}", originalFilename, contentType);

        if(StringUtils.isEmpty(originalFilename))
        {
            return response;
        }

        // 新命名写入数据作为查询使用
        String newFileName = UUID.randomUUID() + "."+ originalFilename.substring(originalFilename.lastIndexOf(".")+ 1);
        logger.info("上传图片:newFileName ={},newFileName ={}", newFileName, originalFilename.substring(originalFilename.lastIndexOf(".")+ 1));

        // 文件保存到指定路径
        try {
            // 保存数据库
            PicVo picVo = new PicVo();
            picVo.setPicName(originalFilename);
            picVo.setCreateTime(new Date());
            picVo.setSeqNo(seqNo);
            picVo.setPicQueryUrl( seqNo + "/" + originalFilename);
            picVo.setEncodedUrl( seqNo + "/" + newFileName);
            if(picService.insertPicVo(picVo) > 0 ){
                String targetPath = webAppConfig.fileRootLocation + seqNo + File.separator;
                logger.info("上传图片位置：:targetPath={}", targetPath);
                FileUtil.saveFile(multipartFile, targetPath, newFileName);
            }else{
                logger.error("上传图片失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
    /**
     * 根据图片序列号查询图片信息,返回文件相对路径:该接口暂时不用
     * PIC为指定接口，固定写死
     */
    @GetMapping(value="getQcon", produces = "application/json; charset=utf-8")
    public BaseResponse getQcon (){
        // 返回结果
        BaseResponse<PicVo> response = new BaseResponse();
        response.setResponseCode(FreshTrackingConstant.SUCCESS_CODE);
        response.setResponseMsg(FreshTrackingConstant.SUCCESS_MSG);
        PicVo picVo = picService.getPicVo(null, 1);
        response.setT(picVo);
        return response;
    }

    /**
     * 根据图片序列号查询图片信息,返回文件相对路径
     */
    @GetMapping(value="getPicList", produces = "application/json; charset=utf-8")
    public BaseResponse getPicDto (@RequestParam(name="seqNo") String seqNo){
        // 返回结果
        BaseResponse<List<PicDto>> response = new BaseResponse<>();
        response.setResponseCode(FreshTrackingConstant.SUCCESS_CODE);
        response.setResponseMsg(FreshTrackingConstant.SUCCESS_MSG);

        // 非空校验
        if(StringUtils.isEmpty(seqNo) ) {
            response.setResponseCode(FreshTrackingConstant.FAILED_CODE);
            response.setResponseMsg("序号为空，请重新输入,谢谢");
            return response;
        }
        // 数字格式校验
        if(!ParamUtil.isNumber(seqNo)){
            response.setResponseCode(FreshTrackingConstant.FAILED_CODE);
            response.setResponseMsg("输入序列号非数字格式，请重新输入,谢谢");
            return response;
        }

        List<PicVo> picVoList = picService.getPicVoList(seqNo);
        List<PicDto> picDtoList = new ArrayList<>(picVoList.size());
        for (PicVo vo: picVoList
                ) {
            PicDto dto = new PicDto();
            dto.setCreateTime(toDateStr(vo.getCreateTime()));
            dto.setId(vo.getId());
            dto.setPicName(vo.getPicName());
            dto.setEncodedUrl(vo.getEncodedUrl());
            dto.setSeqNo(vo.getSeqNo());
            picDtoList.add(dto);
        }
        response.setT(picDtoList);
        return response;
    }

    /**
     * 图片下载：本次暂不处理
     * @param seqNo
     * @param request
     * @param response
     */
    @GetMapping("/downloadImage")
    public void downloadImage(@RequestParam(value ="seqNo") String seqNo, HttpServletRequest request,
                           HttpServletResponse response){
        try {
            String targetParentPath = webAppConfig.fileRootLocation + seqNo + File.separator;
            // 获取指定目录下的文件
            File[] files= FileUtil.getFileListByPath(targetParentPath);
            OutputStream outputStream = response.getOutputStream();
            response.setContentType("application/x-download");
//            response.addHeader("Content-Disposition", "attachment;filename=" + id + ".jpg");
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                System.out.print( file.getName()+ "\n");
                InputStream inputStream = new FileInputStream(file);
                byte[] bs = new byte[1024];
                int len ;
                while ((len = inputStream.read(bs)) != -1){
                    outputStream.write(bs,0 ,len);
                }
                outputStream.flush();
                inputStream.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
