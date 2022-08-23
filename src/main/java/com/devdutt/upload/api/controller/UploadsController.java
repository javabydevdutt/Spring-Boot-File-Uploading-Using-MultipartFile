package com.devdutt.upload.api.controller;

import com.devdutt.upload.api.entity.UploadModel;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

@Controller
public class UploadsController {

    @GetMapping("/uploadfile")
    public String showForm(@ModelAttribute("uploadModel") UploadModel uploadModel) {
        return "jobseeker_register";
    }

    @PostMapping("/uploadfile")
    public String processFile(@ModelAttribute("uploadModel") UploadModel uploadModel, Map<String, Object> map, HttpServletRequest request) throws Exception {

        InputStream is1 = null, is2 = null;
        OutputStream os1 = null, os2 = null;
        ServletContext context = null;
        String photoName = null, resumeName = null;
        File upLoc = null;
        //get the servlet context object
        context = request.getServletContext();

        //check the available upload file location
        upLoc = new File(context.getInitParameter("uplLocation"));
        if (!upLoc.exists()) {
            upLoc.mkdir();
        }//if

        //get the input stream pointing to the upload file
        is1 = uploadModel.getResumeFile().getInputStream();
        is2 = uploadModel.getPhotoFile().getInputStream();

        //get the upload file Name
        resumeName = uploadModel.getResumeFile().getOriginalFilename();
        photoName = uploadModel.getPhotoFile().getOriginalFilename();

        //create output Stream pointing to the Dest. file
        os1 = new FileOutputStream(upLoc.getAbsolutePath() + "/" + resumeName);
        os2 = new FileOutputStream(upLoc.getAbsolutePath() + "/" + photoName);

        // copy the content from source to destination
        IOUtils.copy(is1, os1);
        IOUtils.copy(is2, os2);

        //keep the data in the request scope
        map.put("resumeFile", resumeName);
        map.put("photoFile", photoName);

        // return result page lvn
        return "upload_success";
    }
}
