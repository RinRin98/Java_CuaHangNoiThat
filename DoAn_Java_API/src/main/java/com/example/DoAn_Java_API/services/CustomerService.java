package com.example.DoAn_Java_API.services;

import com.example.DoAn_Java_API.model.ImagesDetail;
import com.example.DoAn_Java_API.model.KhachHang;
import com.example.DoAn_Java_API.repository.IImagesRepository;
import com.example.DoAn_Java_API.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private ICustomerRepository customerRepository;
    @Autowired
    private IImagesRepository imagesRepository;

    public List<KhachHang> getAll()
    {
        return customerRepository.findAll();
    }
    public KhachHang getById(int id){
        Optional<KhachHang> optional = customerRepository.findById(id);
        return optional.orElse(null);
    }
    public KhachHang getByUser_id(Long id){
        Optional<KhachHang> optional = customerRepository.getByUser(id);
        return optional.orElse(null);
    }

    public void addCustomer(KhachHang customer){
        customerRepository.save(customer);
    }
    public void updateCustomer(KhachHang customer) {
        customerRepository.save(customer);

    }
    public void deleteCustomer(int id){
        customerRepository.deleteById(id);
    }
}
