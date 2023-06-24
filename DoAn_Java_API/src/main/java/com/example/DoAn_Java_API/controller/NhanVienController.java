package com.example.DoAn_Java_API.controller;

import com.example.DoAn_Java_API.config.Security.HasRoleADMIN;
import com.example.DoAn_Java_API.model.NhanVien;
import com.example.DoAn_Java_API.modelDto.NhanVienDto;
import com.example.DoAn_Java_API.services.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9998")
@RequestMapping("/nhanvien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @GetMapping("")
    public List<NhanVien> GetAll() {
        return nhanVienService.getAll();
    }

    @GetMapping("/{id}")
    public NhanVien get(@PathVariable long  id)
    {
        return nhanVienService.getProductById(id);
    }
    @GetMapping("/findByCategory/{category_id}")
    public List<NhanVien> findByCategory(@PathVariable long  category_id)
    {
        return nhanVienService.getProductByCategory(category_id);
    }
    @HasRoleADMIN
    @PostMapping("")
    public NhanVien create(@RequestBody NhanVienDto productDto){
        return nhanVienService.addProduct(productDto);
    }
    @HasRoleADMIN
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        nhanVienService.deleteProduct(id);
    }
    @HasRoleADMIN
    @PutMapping("/{id}")
    public ResponseEntity<NhanVien> update(@RequestBody NhanVienDto productDto) {
        NhanVien existingProduct = nhanVienService.updateProduct(productDto);
        if (existingProduct != null) {
            return ResponseEntity.ok(existingProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
