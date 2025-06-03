package com.framepi.web_interface;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    private static final Dotenv dotenv = Dotenv.configure()
                                               .directory(System.getProperty("user.dir"))
                                               .ignoreIfMissing()
                                               .load();
    private static final String UPLOAD_DIR = dotenv.get("UPLOAD_DIR", "uploads");

    @PostMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("uploadImage") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return "No file selected.";
        }
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        File dest = new File(uploadDir, file.getOriginalFilename());
        file.transferTo(dest);
        return "File uploaded successfully: " + dest.getAbsolutePath();
    }
}