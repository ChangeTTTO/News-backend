package com.pn.news.Controller;

import com.pn.news.common.Result;
import com.pn.news.Exception.ArgumentException;
import com.pn.news.Service.FileService;
simport io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "文件接口")
@RestController
@RequestMapping("/file")
@Slf4j
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
    @Operation(summary = "文件上传")
    public Result fileUpload(@RequestParam("data") MultipartFile data, @RequestParam(defaultValue = "local") String flavor) {
        if (data.isEmpty()) {
            throw ArgumentException.getInstance();
        }

//       log.info("file type {}",data.getContentType());
      log.info("file name {}",data.getOriginalFilename());
//        log.info("file size {}",data.getSize());

        String FileName = fileService.fileUpload(data, flavor);

        return Result.INSTANCE.success(FileName);
    }
    /**
     * 根据文件名返回文件
     */
    @GetMapping("/{name}")
    public Result show(@PathVariable String name){
        fileService.loadAsFile(name);
    }

}
