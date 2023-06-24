package com.example.DoAn_Java_API.modelDto;

import com.example.DoAn_Java_API.model.ChucVu;
import com.example.DoAn_Java_API.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class NhanVienDto {
    private  Long idNV;
    private  String Hoten;
    private  String SDT;
    private  String Email;
    private  Boolean GioiTinh;
    private Long user_id;
    private Long idCV;
}
