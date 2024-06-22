package com.xdz.orchard.controller;

import com.xdz.orchard.utils.HttpResponse;
import com.xdz.orchard.utils.ResultBuilder;
import com.xdz.orchard.utils.ResultCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("file")
public class FileController {
    @Value("${file.path}")
    private String filePath;

    @PostMapping("/upload/img")
    @ResponseBody
    public HttpResponse uploadImg(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();// 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 后缀名

        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, String> map = new HashMap<>();
        map.put("fileUrl", "http://localhost:9090/uploadFile/" + fileName);
        return ResultBuilder.success(map, ResultCode.UPLOAD_SUCCESS);
    }
}
