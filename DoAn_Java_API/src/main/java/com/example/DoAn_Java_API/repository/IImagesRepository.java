package com.example.DoAn_Java_API.repository;

import com.example.DoAn_Java_API.model.ImagesDetail;
import com.example.DoAn_Java_API.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImagesRepository extends JpaRepository<ImagesDetail, Integer> {
    @Query("SELECT i FROM ImagesDetail i WHERE i.product.id = ?1")
    List<ImagesDetail> findImageOfProduct(Long id);
}