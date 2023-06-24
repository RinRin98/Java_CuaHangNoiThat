package com.example.DoAn_Java_API.controller;

import com.example.DoAn_Java_API.config.Security.HasRoleADMIN;
import com.example.DoAn_Java_API.model.ImagesDetail;
import com.example.DoAn_Java_API.model.Products;
import com.example.DoAn_Java_API.modelDto.ImageDto;
import com.example.DoAn_Java_API.modelDto.ProductDto;
import com.example.DoAn_Java_API.services.ImagesService;
import com.example.DoAn_Java_API.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9998")
@RequestMapping("/images")

public class ImagesController {
    @Autowired
    private ImagesService imagesService;
    @GetMapping("")
    public List<ImagesDetail> GetAll() {
        return imagesService.getAll();
    }
    @GetMapping("/{id}")
    public List<ImagesDetail> GetImagesOfProduct(@PathVariable long id) {
        return imagesService.getImagesOfProduct(id);
    }
    @HasRoleADMIN
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try{
            imagesService.delete(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }catch (Throwable e){
            return ResponseEntity.notFound().build();
        }

    }
    @HasRoleADMIN
    @PostMapping("")
    public ImagesDetail create(@RequestBody ImageDto imageDto){
        return imagesService.addImage(imageDto);
    }
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable long id) {
//        productService.deleteProduct(id);
//    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Products> update(@RequestBody ProductDto productDto) {
//        Products existingProduct = productService.updateProduct(productDto);
//        if (existingProduct != null) {
//            return ResponseEntity.ok(existingProduct);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

}
