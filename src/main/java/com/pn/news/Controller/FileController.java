package com.pn.news.Controller;

import com.pn.news.common.Result;
import com.pn.news.Exception.ArgumentException;
import com.pn.news.Service.FileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "文件接口")
@RestController
public class FileController {
    @Resource
    private FileService fileService;

    /**
     * 表单方式上传文件
     * @param data   文件对象，表单字段名称为data，类似为file
     * @param flavor 渠道，例如：客户端会传递prod，dev，local等值，服务端方便保存到不同地方，这样后面好清理测试资源
     */
    @PostMapping("/fileUpload")
    @ResponseBody
    public Result create(@RequestParam("data") MultipartFile data, @RequestParam(defaultValue = "local") String flavor) {
        if (data.isEmpty()) {
            throw ArgumentException.getInstance();
        }

//        log.info("file type {}",data.getContentType());
//        log.info("file name {}",data.getOriginalFilename());
//        log.info("file size {}",data.getSize());

      //  String r = service.create(data, flavor);

        return Result.INSTANCE.success();
    }
}
