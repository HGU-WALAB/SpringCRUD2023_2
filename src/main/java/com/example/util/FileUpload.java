package com.example.util;

import com.example.vo.PlayerVo;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class FileUpload {
    public static PlayerVo uploadPhoto(HttpServletRequest request, String oldfilename){
        String filename="";
        int sizeLimit=15*1024*1024;

        String realPath = request.getServletContext().getRealPath("resources/image");
        System.out.println(realPath);
        File dir = new File(realPath);
        if(!dir.exists()) dir.mkdir();

        PlayerVo one=null;
        MultipartRequest multipartRequest=null;
        try{
            multipartRequest= new MultipartRequest(request,realPath,sizeLimit,"utf-8",new DefaultFileRenamePolicy());
            filename=multipartRequest.getFilesystemName("photo");
            one=new PlayerVo();
            String id=multipartRequest.getParameter("id");
            if(id!=null&&!id.equals("")) one.setId(Integer.parseInt(id));
            one.setName(multipartRequest.getParameter("name"));
            one.setWeight(Integer.parseInt(multipartRequest.getParameter("weight")));
            one.setHeight(Integer.parseInt(multipartRequest.getParameter("height")));
            one.setBirthday(Date.valueOf(multipartRequest.getParameter("birthday")));
            one.setFormation(multipartRequest.getParameter("formation"));
            one.setPass(Integer.parseInt(multipartRequest.getParameter("pass")));
            one.setShoot(Integer.parseInt(multipartRequest.getParameter("shoot")));
            one.setDefense(Integer.parseInt(multipartRequest.getParameter("defense")));
            one.setSpeed(Integer.parseInt(multipartRequest.getParameter("speed")));
            one.setIntelligence(Integer.parseInt(multipartRequest.getParameter("intelligence")));
            one.setGoalkeeping(Integer.parseInt(multipartRequest.getParameter("goalkeeping")));

            if(id!=null && !id.equals("")){
                if(filename!=null && oldfilename!=null)
                    FileUpload.deleteFile(request,oldfilename);
                else if(filename==null&&oldfilename!=null)
                    filename=oldfilename;
            }
            one.setImage(filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return one;
    }

    public static void deleteFile(HttpServletRequest request, String filename) {
        String realPath = request.getServletContext().getRealPath("resources/image");
        File file=new File(realPath+"/"+filename);
        if(file.exists()) file.delete();
    }
}
