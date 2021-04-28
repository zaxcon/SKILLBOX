package org.example.web.controllers;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FilesController {
    public final String ROOT_PATH = System.getProperty("catalina.home");
    public final String DIRECTORY = "external_upload";

    @GetMapping("/upload")
    public String upload() {
        return "upload_file";
    }

    @GetMapping("/download")
    public String download(Model model) {
        File dir = new File(ROOT_PATH + File.separator + DIRECTORY);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String[] files = dir.list();
        model.addAttribute("files", files);
        return "download_file";
    }

    @GetMapping("/download/{file:.+}")
    @ResponseBody
    public FileSystemResource downloadFile(@PathVariable("file") String fileString, HttpServletResponse response)
    {
        Path file = Paths.get(ROOT_PATH+File.separator+DIRECTORY, fileString);
        if (Files.exists(file)){
            response.setHeader("Content-disposition", "attachment;filename=" + fileString);
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            return new FileSystemResource(file);
        }
    return null;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) throws Exception
    {
        if (!file.isEmpty()) {
            String name = file.getOriginalFilename();
            byte[] bytes = file.getBytes();

            File dir = new File(ROOT_PATH + File.separator + DIRECTORY);
            if (!dir.exists()) {
                dir.mkdir();
            }
            File serverFile = new File(dir + File.separator + name);
            System.out.println(serverFile.getAbsolutePath());
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            return "redirect:/download";
        }
        model.addAttribute("error","file should not be empty");
        return "upload_file";
    }
}
