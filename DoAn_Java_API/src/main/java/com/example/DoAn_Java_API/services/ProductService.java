package com.example.DoAn_Java_API.services;

import com.example.DoAn_Java_API.model.Category;
import com.example.DoAn_Java_API.model.ImagesDetail;
import com.example.DoAn_Java_API.model.Products;
import com.example.DoAn_Java_API.modelDto.ProductDto;
import com.example.DoAn_Java_API.repository.ICategoryRepository;
import com.example.DoAn_Java_API.repository.IImagesRepository;
import com.example.DoAn_Java_API.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private IProductsRepository productsRepository;
    @Autowired
    private IImagesRepository imagesRepository;
    @Autowired
    private CategoryService categoryService;
    public List<Products> getAll()
    {
        List<Products> list= productsRepository.findAll();
        list .sort(Comparator.comparing(Products::getId));
        return list;
    }
    public List<Products> getProductByCategory(Long category_id){return productsRepository.findByCategoryId(category_id);}
    public Products getProductById(Long id){
        Optional<Products> optional = productsRepository.findById(id);
        return optional.orElse(null);
    }
    private Products convertToProduct(ProductDto productDto){
        Products product= new Products();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setSoLuong(productDto.getSoLuong());
        Category category= categoryService.getCategoryById(productDto.getCategory_id());
        product.setCategory(category);
        return product;
    }
    public Products addProduct(ProductDto productDto){
        return productsRepository.save(convertToProduct(productDto));
    }
    public Products updateProduct(ProductDto productDto) {
        Optional<Products> optional = productsRepository.findById(productDto.getId());
        if (optional.isPresent()) {
            return  productsRepository.save(convertToProduct(productDto));
        }
        return null;
    }
    public void deleteProduct(Long id){
        productsRepository.deleteById(id);
    }
}
