package com.example.DoAn_Java_API.services;

import com.example.DoAn_Java_API.model.Category;
import com.example.DoAn_Java_API.model.ChucVu;
import com.example.DoAn_Java_API.repository.ICategoryRepository;
import com.example.DoAn_Java_API.repository.IChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChucVuService {
    @Autowired
    private IChucVuRepository chucVuRepository;

    public List<ChucVu> getAllCategories() {
        return chucVuRepository.findAll();
    }

    public ChucVu getCategoryById(Long id) {
        Optional<ChucVu> optional = chucVuRepository.findById(id);
        return optional.orElse(null);
    }

    public ChucVu addCategory(ChucVu category) {
        return chucVuRepository.save(category);
    }

    public void updateCategory(ChucVu category) {
        chucVuRepository.save(category);
    }

    public boolean deleteCategory(Long id) {
        Optional<ChucVu> optional = chucVuRepository.findById(id);
        if (optional.isPresent()) {
            chucVuRepository.delete(optional.get());
            return true;
        }
        return false;
    }
}
