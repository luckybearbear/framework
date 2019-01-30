package com.zj.upms.server.controller.manage;

import com.zj.common.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.Iterator;

/**
 * describe:
 *
 * @author zj
 * @date 2019/01/29
 */
@Controller
@RequestMapping("/manage/fileUpload")
public class UpmsFileUploadController extends BaseController {
    @ApiOperation(value = "上传测试首页")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/manage/fileUpload/index.jsp";
    }
    /**
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param file
     * @return
     */
    @RequestMapping("/upload_01")
    public String fileUpload_1(@RequestParam("file_01")CommonsMultipartFile file)throws IOException {
        //用来检测程序运行时间
        long startTime = System.currentTimeMillis();
        System.out.println("fileName:"+file.getOriginalFilename());

        try{
            //获取输出流
            OutputStream os = new FileOutputStream("E:/"+new Date().getTime()+file.getOriginalFilename());
            //获取输入流CommonsMultipartFile中可以直接得到文件的流
            InputStream is = file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1)){
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法一的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "/manage/fileUpload/success.jsp";
    }

    /**
     * 采用file.Transto 来保存上传的文件
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload_02")
    public String fileUpload_2(@RequestParam("file_02") CommonsMultipartFile file)throws IOException {
        long startTime = System.currentTimeMillis();
        System.out.println("fileName:"+file.getOriginalFilename());
        String path = "E:/"+new Date().getTime()+file.getOriginalFilename();

        File newFile = new File(path);
        //通过CommonsMultipartFile 的方法直接写文件
        file.transferTo(newFile);
        long endTime = System.currentTimeMillis();
        System.out.println("方法二的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "/manage/fileUpload/success.jsp";
    }

    /**
     * 使用MultipartFile上传文件
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param file
     * @return
     */
    @RequestMapping("/upload_03")
    public String fileUpload_3(@RequestParam(value="file_03",required=false)MultipartFile file,
                               HttpServletRequest request){
        String path = request.getSession().getServletContext().getRealPath("upload");
        System.out.println(path);
        String fileName = file.getOriginalFilename();
        File targetFile = new File(path,fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "/manage/fileUpload/success.jsp";
    }

    /**
     * 采用spring提供的上传文件的方法
     * <请替换成功能描述> <br>
     * <请替换成详细描述>
     * @param request
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/upload_spring")
    public String springUpload(HttpServletRequest request)throws IllegalStateException, IOException{
        long startTime = System.currentTimeMillis();
        //将当前上下文初始化给 CommonsMutipartResolver (多部分解析器)
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //获取multiRequest中所有的文件名
            Iterator iter = multiRequest.getFileNames();

            while(iter.hasNext()){
                //一次遍历所有的文件
                MultipartFile file = multiRequest.getFile(iter.next().toString());
                if(file!=null){
                    String path = "E:/springUpload"+file.getOriginalFilename();
                    //上传
                    file.transferTo(new File(path));
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "/manage/fileUpload/success.jsp";
    }
    @RequestMapping("openDialog")
    @ApiOperation(value = "openDialog")
    public String openDialog (){
        return "/manage/fileUpload/dialog.jsp";
    }
}
