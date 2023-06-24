package com.example.DoAn_Java_API.controller;

import com.example.DoAn_Java_API.config.AuthenticationConfig;
import com.example.DoAn_Java_API.config.Security.HasRole;
import com.example.DoAn_Java_API.config.Security.HasRoleADMIN;
import com.example.DoAn_Java_API.model.Products;
import com.example.DoAn_Java_API.modelDto.ProductDto;
import com.example.DoAn_Java_API.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin(origins = "http://localhost:9998")
@RequestMapping("/products")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ProductsController {
    @Autowired
    private ProductService productService;

    @Autowired
    AuthenticationConfig AuthenticationConfig;
    @GetMapping("")
    public List<Products> GetAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Products get(@PathVariable long  id)
    {
        return productService.getProductById(id);
    }
    @GetMapping("/findByCategory/{category_id}")
    public List<Products> findByCategory(@PathVariable long  category_id)
    {
        return productService.getProductByCategory(category_id);
    }
    @PostMapping("")
    @HasRoleADMIN
    public Products create(@RequestBody ProductDto productDto){
        return productService.addProduct(productDto);
    }
    @DeleteMapping("/{id}")
    @HasRoleADMIN
    public void delete(@PathVariable long id) {
        productService.deleteProduct(id);
    }
    @PutMapping("/{id}")
    @HasRoleADMIN
    public ResponseEntity<Products> update(@RequestBody ProductDto productDto) {
        Products existingProduct = productService.updateProduct(productDto);
        if (existingProduct != null) {
            return ResponseEntity.ok(existingProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/home/{n}")
    public List<Products> randomListN(@PathVariable int n) {

        List<Products> allProducts = productService.getAll();

        int totalProducts = allProducts.size();
        int randomProductCount = Math.min(totalProducts, n); // Lấy tối đa n sản phẩm ngẫu nhiên

        // Tạo một danh sách chứa các chỉ số ngẫu nhiên của sản phẩm
        List<Integer> randomIndices = new ArrayList<>();
        Random random = new Random();
        while (randomIndices.size() < randomProductCount) {
            int randomIndex = random.nextInt(totalProducts);
            if (!randomIndices.contains(randomIndex)) {
                randomIndices.add(randomIndex);
            }
        }

        // Lấy các sản phẩm tại các chỉ số ngẫu nhiên từ danh sách sản phẩm
        List<Products> randomProducts = new ArrayList<>();
        for (int index : randomIndices) {
            randomProducts.add(allProducts.get(index));
        }

        return randomProducts;
    }
    @GetMapping("/home")
    public List<Products> randomList() {
        return randomListN(14);
    }
}
