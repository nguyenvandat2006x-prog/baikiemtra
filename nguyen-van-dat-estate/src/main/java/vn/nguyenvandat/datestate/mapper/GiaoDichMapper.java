package vn.nguyenvandat.datestate.mapper;

import vn.nguyenvandat.datestate.dto.GiaoDichDetail;
import vn.nguyenvandat.datestate.dto.GiaoDichForm;
import vn.nguyenvandat.datestate.dto.GiaoDichListItem;
import vn.nguyenvandat.datestate.entity.GiaoDich;
import vn.nguyenvandat.datestate.entity.KhachHang;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class GiaoDichMapper {

    public GiaoDichListItem toListItem(GiaoDich giaoDich) {
        return new GiaoDichListItem(
                giaoDich.getMaGiaoDich(),
                giaoDich.getKhachHang().getTenKhachHang(),
                giaoDich.getLoaiDichVu(),
                giaoDich.getNgayGiaoDich(),
                giaoDich.getDonGia(),
                chuanHoaDienTich(giaoDich.getDienTich())
        );
    }

    public GiaoDichDetail toDetail(GiaoDich giaoDich) {
        KhachHang khachHang = giaoDich.getKhachHang();
        return new GiaoDichDetail(
                giaoDich.getMaGiaoDich(),
                giaoDich.getLoaiDichVu(),
                giaoDich.getNgayGiaoDich(),
                giaoDich.getDonGia(),
                chuanHoaDienTich(giaoDich.getDienTich()),
                khachHang.getTenKhachHang(),
                khachHang.getSoDienThoai(),
                khachHang.getEmail()
        );
    }

    public GiaoDich toEntity(GiaoDichForm form, KhachHang khachHang) {
        GiaoDich giaoDich = new GiaoDich();
        giaoDich.setMaGiaoDich(form.getMaGiaoDich());
        capNhatThongTin(giaoDich, form, khachHang);
        return giaoDich;
    }

    public GiaoDichForm toForm(GiaoDich giaoDich) {
        GiaoDichForm form = new GiaoDichForm();
        form.setMaGiaoDich(giaoDich.getMaGiaoDich());
        form.setMaKhachHang(giaoDich.getKhachHang().getMaKhachHang());
        form.setLoaiDichVu(giaoDich.getLoaiDichVu());
        form.setNgayGiaoDich(giaoDich.getNgayGiaoDich());
        form.setDonGia(giaoDich.getDonGia());
        form.setDienTich(giaoDich.getDienTich());
        return form;
    }

    public void capNhatThongTin(GiaoDich giaoDich, GiaoDichForm form, KhachHang khachHang) {
        giaoDich.setKhachHang(khachHang);
        giaoDich.setLoaiDichVu(form.getLoaiDichVu());
        giaoDich.setNgayGiaoDich(form.getNgayGiaoDich());
        giaoDich.setDonGia(form.getDonGia());
        giaoDich.setDienTich(form.getDienTich());
    }

    private BigDecimal chuanHoaDienTich(BigDecimal dienTich) {
        return dienTich.stripTrailingZeros();
    }
}
