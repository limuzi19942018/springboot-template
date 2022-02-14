package com.shannonai.springboot.module.system.controller;

import com.shannonai.springboot.base.tips.ErrorTip;
import com.shannonai.springboot.base.tips.SuccessTip;
import com.shannonai.springboot.properties.MinioProp;
import com.shannonai.springboot.utils.MinioUtil;
import com.shannonai.springboot.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description: TODO
 * @Author ligang
 * @Date 2021/8/2 14:45
 */
@RestController
@RequestMapping(value = "/api/file")
public class FileController {

    @Autowired
    private MinioUtil minioUtil;

    @Autowired
    private MinioProp minioProp;

    //上传文件到minio服务
    @RequestMapping(value = "/upload")
    @ResponseBody
    public Object upload(@RequestParam("file") MultipartFile file)  {
        try {
            String fileName = ObjectUtils.getShortUuid() + "." + getExtensionName(file.getOriginalFilename());
            minioUtil.putObject(minioProp.getBucketName(), file, fileName);
            String retUrl = minioProp.getEndpoint() + "/" + minioProp.getBucketName() + "/" + fileName;
            return new SuccessTip(retUrl);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ErrorTip();

    }

    //上传文件到minio服务
    @RequestMapping(value = "/download")
    @ResponseBody
    public void download(HttpServletResponse response)  {
        minioUtil.downloadFile(minioProp.getBucketName(),
                "1a22cac7ba3d48c4bfcacf75964838e1.pdf","中国共产党万岁.pdf", response);
    }

    /**
     * 获取文件后缀名
     *
     * @param filename
     * @return
     */
    public String getExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

}
