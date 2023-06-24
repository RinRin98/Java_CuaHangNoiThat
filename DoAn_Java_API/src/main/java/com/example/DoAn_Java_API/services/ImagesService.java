package com.example.DoAn_Java_API.services;

import com.example.DoAn_Java_API.model.Category;
import com.example.DoAn_Java_API.model.ImagesDetail;
import com.example.DoAn_Java_API.model.Products;
import com.example.DoAn_Java_API.modelDto.ImageDto;
import com.example.DoAn_Java_API.modelDto.ProductDto;
import com.example.DoAn_Java_API.repository.IImagesRepository;
import com.example.DoAn_Java_API.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class ImagesService {
    @Autowired
    private ProductService productService;
    @Autowired
    private IImagesRepository imagesRepository;
    public List<ImagesDetail> getAll()
    {
        return imagesRepository.findAll();
    }
    public List<ImagesDetail> getImagesOfProduct(Long id){
        return imagesRepository.findImageOfProduct(id);
    }
    public ImagesDetail addImage(ImageDto imageDto){
        ImagesDetail imagesDetail= new ImagesDetail();
        imagesDetail.setId(imageDto.getId());
        imagesDetail.setImage(imageDto.getImage());
        Products products= productService.getProductById(imageDto.getProduct_id());
        imagesDetail.setProduct(products);
        return imagesRepository.save(imagesDetail);
    }
//    public Products updateProduct(ProductDto productDto) {
//        Optional<Products> optional = productsRepository.findById(productDto.getId());
//        if (optional.isPresent()) {
//            return  productsRepository.save(convertToProduct(productDto));
//        }
//        return null;
//    }
    public void delete(int id){
        imagesRepository.deleteById(id);
    }
}
