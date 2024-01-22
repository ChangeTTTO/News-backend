package com.pn.news.Controller;

import com.pn.news.common.Result;
import com.pn.news.Exception.ArgumentException;
import com.pn.news.Service.FileService;
import com.pn.news.utils.Constant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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
    @Operation(summary = "根据文件名返回文件")
    public Object show(@PathVariable String name){
        //创建一个文件对象
        File file = new File(Constant.DIR_UPLOAD,name);
        if (!file.exists()){
            throw new RuntimeException();
        }

        String contentType =null;
        //获取文件的绝对路径
        Path path = Paths.get(file.getAbsolutePath());
        //获取文件类型
        try {
            contentType = Files.probeContentType(path);
        } catch (IOException e) {
            contentType="application/octet-stream";   //二进制流
        }
        return ResponseEntity.ok()
                //下载
              //  .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+ file.getName()+"\"")
                //设置文件类型，浏览器能预览的文件就会直接预览
                .contentType(MediaType.parseMediaType(contentType))
                .body(new FileSystemResource(file));
    }
    /**
     * 批量上传
     * @param files 文件对象列表
     */
    @PostMapping("/multiFile")
    @ResponseBody
    @Operation(summary = "批量上传")
    public Object creates(@RequestParam("data") MultipartFile[] files, @RequestParam(defaultValue = "local") String flavor) {
        if (files.length == 0) {
            throw ArgumentException.getInstance();
        }
        ArrayList<String> r = new ArrayList<>();
        for (MultipartFile it : files) {
            if (it.isEmpty()) {
                throw  ArgumentException.getInstance();
            }
            //文件上传
            r.add(fileService.fileUpload(it, flavor));
        }
        if (r.size() != files.length) {
            log.warn("upload file length error {} {}", r.size(), files.length);
          throw new RuntimeException();
        }
        return Result.INSTANCE.success(r);
    }

}
