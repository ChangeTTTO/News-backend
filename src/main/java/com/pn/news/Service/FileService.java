package com.pn.news.Service;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.util.IdUtil;
import com.pn.news.utils.Constant;
import com.pn.news.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {
    public String fileUpload(MultipartFile data, String flavor){
        //生成随机文件名称
        String name = IdUtil.fastSimpleUUID();
        //拿到后缀
        String suffix = FileNameUtil.extName(data.getOriginalFilename());

        //生成文件名
        String targetName = String.format("%s%s.%s",name,flavor,suffix);

        //创建文件对象
        File targetFile = new File(Constant.DIR_UPLOAD, targetName);
        //保存文件
        try {
            //获取文件输入流，并保存到一个地址中
            cn.hutool.core.io.FileUtil.writeFromStream(data.getInputStream(),targetFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //返回一个文件路径
        return String.format("r/%s",targetFile);
    }

    public File loadAsFile(String name) {
        File file = new File(Constant.DIR_UPLOAD,name);
        return file;
    }
}
