package com.jacle.spboot.controller;

import com.jacle.spboot.domain.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/**
 * @author Jacle
 * @version 1.0
 * @description: 文件上传处理类
 * @date 2021/12/22 12:31
 */

@Controller
public class FileUploadController
{
    @Value("${savepath}")
    private String fileDir;

    //直接跳转到指定页面,测试没有参数
    //通过此可以获取参数
    @RequestMapping("/picUpload")
    public String picUpload(Model model, HttpServletRequest request)
    {
        System.out.println("页面传递过来得参数:" + request.getParameter("initParam"));

        return "picUpload";
    }


    @RequestMapping("/mupload")
    public String mupload(Model model, HttpServletRequest request)
    {
        System.out.println("页面传递过来得参数:" + request.getParameter("initParam"));

        return "mupload";
    }

    //单纯的响应
    @ResponseBody
    @PostMapping("/upload")
    public Object upload(MultipartFile fileUpload)
    {
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID() + suffixName;

        //指定本地文件夹存储图片
        try
        {
            System.out.println("------->>" + fileDir);
            File dir = new File(fileDir);
            if (!dir.exists())
            {
                dir.mkdirs();
            }

            File upload_file = new File(fileDir, fileName);
            fileUpload.transferTo(upload_file);
            return new Message(0, "success to upload");
        } catch (Exception e)
        {
            e.printStackTrace();
            return new Message(-1, "fail to upload");
        }

    }

    @RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadMultiFile(@RequestParam("attachment") MultipartFile[] fileUpload)
    {
        try
        {
            for (int i = 0; i < fileUpload.length; i++)
            {
                //获取文件名
                String fileName = fileUpload[i].getOriginalFilename();
                //指定本地文件夹存储图片
                File dir = new File(fileDir);
                if (!dir.exists())
                {
                    dir.mkdirs();
                }

                if (fileUpload[i] != null&& !StringUtils.isEmpty(fileName))
                {
                    System.out.println(fileUpload[i]);
                    System.out.println(fileUpload[i].getOriginalFilename());
                    File upload_file = new File(fileDir + fileName);
                    fileUpload[i].transferTo(upload_file);
                }
            }
            return new Message(0, "success to upload");
        } catch (Exception e)
        {
            e.printStackTrace();
            return new Message(-1, "fail to upload");
        }
    }

}
