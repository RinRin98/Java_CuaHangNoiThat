package com.example.DoAn_Java_API.services;

import com.example.DoAn_Java_API.model.*;
import com.example.DoAn_Java_API.modelDto.NhanVienDto;
import com.example.DoAn_Java_API.modelDto.ProductDto;
import com.example.DoAn_Java_API.repository.IChucVuRepository;
import com.example.DoAn_Java_API.repository.IImagesRepository;
import com.example.DoAn_Java_API.repository.INhanVienRepository;
import com.example.DoAn_Java_API.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private INhanVienRepository nhanVienRepository;
    @Autowired
    private ChucVuService chucVuService;
    @Autowired
    private UserService userService;
    public List<NhanVien> getAll()
    {
        List<NhanVien> list= nhanVienRepository.findAll();
        list .sort(Comparator.comparing(NhanVien::getIdNV));
        return list;
    }
    public List<NhanVien> getProductByCategory(Long category_id){return nhanVienRepository.findByChucVu(category_id);}
    public NhanVien getProductById(Long id){
        Optional<NhanVien> optional = nhanVienRepository.findById(id);
        return optional.orElse(null);
    }
    private NhanVien convertToNhanVien(NhanVienDto nhanVienDto){
        NhanVien product= new NhanVien();
        product.setIdNV(nhanVienDto.getIdNV());
        product.setHoten(nhanVienDto.getHoten());
        product.setSDT(nhanVienDto.getSDT());
        product.setGioiTinh(nhanVienDto.getGioiTinh());
        product.setEmail(nhanVienDto.getEmail());
        ChucVu category= chucVuService.getCategoryById(nhanVienDto.getIdCV());
        product.setChucVu(category);
        User user= userService.getByUserID(nhanVienDto.getUser_id());
        product.setUser(user);
        return product;
    }
    public NhanVien addProduct(NhanVienDto productDto){
        return nhanVienRepository.save(convertToNhanVien(productDto));
    }
    public NhanVien updateProduct(NhanVienDto productDto) {
        Optional<NhanVien> optional = nhanVienRepository.findById(productDto.getIdNV());
        if (optional.isPresent()) {
            return  nhanVienRepository.save(convertToNhanVien(productDto));
        }
        return null;
    }
    public void deleteProduct(Long id){
        nhanVienRepository.deleteById(id);
    }
}
