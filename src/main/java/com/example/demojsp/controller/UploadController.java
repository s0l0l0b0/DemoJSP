package com.example.demojsp.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadController {

    @GetMapping("/upload")
    public String getUploadPage(Model model) {
        return "multipleImageUploadTest";
    }

    @PostMapping("/multiple/upload")
    public String multipleUpload(@RequestPart(value = "images") List<MultipartFile> lookInsideImages,
                                 @RequestParam(value = "image-names-in-re-order", required = false) String reOrderNames) {
        System.out.println("Size of iamges: " + lookInsideImages.size());
        System.out.println("ReorderNames:" + reOrderNames);

        for (MultipartFile file : lookInsideImages) {
            System.out.println("Name: " + file.getOriginalFilename());
        }

        List<MultipartFile> reorderedLookInsideImages = new ArrayList<>();
        if (StringUtils.isNotBlank(reOrderNames)) {
            final String[] reorderedIndex = reOrderNames.split(",");
            for (String index : reorderedIndex) {
                int i = Integer.parseInt(index);
                reorderedLookInsideImages.add(lookInsideImages.get(i-1));
            }
            if (!CollectionUtils.isEmpty(reorderedLookInsideImages)) {
                System.out.println("After reOrdering: ");
                for (MultipartFile file : reorderedLookInsideImages) {
                    System.out.println("Name: " + file.getOriginalFilename());
                }
            }
        }

        return "multipleImageUploadTest";
    }
}