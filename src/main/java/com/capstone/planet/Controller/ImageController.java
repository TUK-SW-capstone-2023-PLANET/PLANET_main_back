package com.capstone.planet.Controller;

import com.capstone.planet.Model.DTO.ImageDTO;
import com.capstone.planet.Service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "Image", description = "사진 관련 API")
@RestController
@CrossOrigin("*")
public class ImageController {

    ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    // 이미지 저장
    @Operation(summary = "이미지 저장", description = "멀티파일로 이미지 저장 후 imageUrl 반환")
    @PostMapping("image")
    public ImageDTO saveImage(@RequestParam("file") MultipartFile file) throws IOException {

        return imageService.saveImage(file);
    }

    // 여러 이미지 저장
    @Operation(summary = "여러 이미지 저장", description = "멀티파일로 여러 이미지 저장 후 imageUrls 반환")
    @PostMapping("images")
    public List<ImageDTO> saveImages(@RequestParam("files") List<MultipartFile> files) throws IOException {
        List<ImageDTO> imageDTOs = new ArrayList<>();
        for (MultipartFile file : files) {
            imageDTOs.add(imageService.saveImage(file));
        }
        return imageDTOs;
    }
}
