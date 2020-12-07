package com.yuk.controller;

import com.google.gson.Gson;
import com.yuk.bean.Adm;
import com.yuk.bean.User;
import com.yuk.service.AdmService;
import com.yuk.service.Impl.AdmServiceImpl;
import com.yuk.service.Impl.UserServiceImpl;
import com.yuk.service.UserService;
import com.yuk.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author yuk
 * @version 1.0
 * @date 2020/11/25 10:20
 */
public class UserServlet extends BaseServlet {

    private UserService userService=new UserServiceImpl();
    protected void ulogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println("经过了这里"+req.getContextPath());
        User login = userService.login(name, password);



        if (name.equals(login.getName())&&password.equals(login.getPassword())){
            System.out.println("登陆成功");
            //查找该用户的头像路径
//           String photo =  userService.getPhoto(login.getId());
            String photo =login.getPhotoPath();
            if (photo==null||photo==""){
                System.out.println("还没有上传头像");
            }
            req.getSession().setAttribute("photo",photo);
            req.getSession().setAttribute("userId",login.getId());
            req.getRequestDispatcher("/homepage.jsp").forward(req,resp);
        }else {
            System.out.println("登录失败");
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void register(HttpServletRequest req,HttpServletResponse resp)  throws ServletException, IOException{


        Map<String, String[]> parameterMap = req.getParameterMap();
        User user = WebUtils.copyParamToBean(parameterMap, new User());

        //判断用户是否存在
        if (userService.existsUser(user.getName())){
            System.out.println("用户已存在");
            req.setAttribute("msg","用户已存在");
            req.getRequestDispatcher("/pages/user/index.jsp").forward(req,resp);
        }else {
            userService.register(user);
            req.getRequestDispatcher("/pages/user/index.jsp").forward(req,resp);
        }

    }

    protected void ajaxExistsUser(HttpServletRequest req,HttpServletResponse resp)  throws ServletException, IOException{
        String username = req.getParameter("username");

        //判断用户是否存在
        boolean b = userService.existsUser(username);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("existUsername",b);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.setStatus(0);
        resp.getWriter().write(json);

    }

    protected void upLoadPhoto(HttpServletRequest req,HttpServletResponse resp)  throws ServletException, IOException{
        int userId =(int) req.getSession().getAttribute("userId");
        String savePath = this.getServletContext().getRealPath("/upload");
        if (ServletFileUpload.isMultipartContent(req)){
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);

                for (FileItem fileItem : list) {
                    //判断是否是普通表单项
                    if (fileItem.isFormField()){
                        System.out.println("表单项name的属性值："+fileItem.getFieldName());
                        //参数UTF-8解决中文乱码问题
                        System.out.println("表单项value的值；"+fileItem.getString("UTF-8"));
                    }
                    else {

                        String filename=fileItem.getName();
                        System.out.println(filename);

                        if (filename==null||filename.trim().equals("")){
                            continue;
                        }
                        filename = filename.substring(filename.lastIndexOf("\\")+1);
                             //得到上传文件的扩展名
                        String fileExtName = filename.substring(filename.lastIndexOf(".")+1);
                        String saveFilename = makeFileName(filename);
                        String realSavePath = makePath(saveFilename, savePath);
                        String substring = realSavePath.substring(48);
                        FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFilename);

                        InputStream is = fileItem.getInputStream();
                        //存入服务器下的webinfo/upload目录下
                        byte[] buffer=new byte[1024];
                        int len=0;
                        while ((len=is.read(buffer))!=-1){
                            out.write(buffer,0,len);
                        }
                        is.close();
                        out.close();
                        System.out.println("上传成功");
                        req.getSession().setAttribute("photo",substring+"\\"+saveFilename);

                        //将服务器上的图片路径存入数据库
                        String path=substring+"\\"+saveFilename;
                        userService.upPhoto(path,userId);
                        resp.sendRedirect(req.getContextPath());
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }





    private String makeFileName(String filename) { // 2.jpg
        // 为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
        return UUID.randomUUID().toString() + "_" + filename;
    }

    private String makePath(String filename, String savePath) {
        // 得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
        int hashcode = filename.hashCode();
        int dir1 = hashcode & 0xf; // 0--15
        int dir2 = (hashcode & 0xf0) >> 4; // 0-15
        // 构造新的保存目录
        String dir = savePath + "\\" + dir1 + "\\" + dir2; // upload\2\3
        // upload\3\5
        // File既可以代表文件也可以代表目录
        File file = new File(dir);
        // 如果目录不存在
        if (!file.exists()) {
            // 创建目录
            file.mkdirs();
        }
        return dir;
    }
}
