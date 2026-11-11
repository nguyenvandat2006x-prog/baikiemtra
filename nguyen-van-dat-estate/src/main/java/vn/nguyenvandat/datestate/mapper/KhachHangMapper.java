package vn.nguyenvandat.datestate.mapper;

import vn.nguyenvandat.datestate.dto.KhachHangForm;
import vn.nguyenvandat.datestate.dto.KhachHangOption;
import vn.nguyenvandat.datestate.entity.KhachHang;
import org.springframework.stereotype.Component;

@Component
public class KhachHangMapper {

    public KhachHangOption toOption(KhachHang khachHang) {
        return new KhachHangOption(khachHang.getMaKhachHang(), khachHang.getTenKhachHang());
    }

    public KhachHang toEntity(KhachHangForm form) {
        KhachHang khachHang = new KhachHang();
        khachHang.setTenKhachHang(form.getTenKhachHang().trim());
        khachHang.setSoDienThoai(form.getSoDienThoai().trim());
        khachHang.setEmail(form.getEmail().trim());
        return khachHang;
    }
}
