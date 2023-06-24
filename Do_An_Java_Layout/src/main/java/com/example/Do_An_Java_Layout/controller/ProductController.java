package com.example.Do_An_Java_Layout.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/products")
public class ProductController {
    @GetMapping("/list")
    String list(){
        return "products/list";
    }
    @GetMapping("/detail")
    String detail(@RequestParam Long id){
        return "products/detail";
    }
    @ResponseBody
    @PostMapping("/inputImages")
    List<String> addImage(@RequestParam("imageProduct") MultipartFile[] imageFiles) {
        List<String> fileNames = new ArrayList<>();

        for (MultipartFile imageFile : imageFiles) {
            long MAX_FILE_SIZE = 1048576;
            if (!imageFile.isEmpty()) {
                if (imageFile.getSize() > MAX_FILE_SIZE) {
                    // Handle the case when the file size exceeds the limit
                    throw new IllegalArgumentException("File size exceeds the maximum allowed limit.");
                }
                try {
                    File saveFile = new ClassPathResource("static/images/product").getFile();
                    String newImageFile = UUID.randomUUID() + ".png";
                    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + newImageFile);
                    Files.copy(imageFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                    fileNames.add(newImageFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return fileNames;
    }
}
