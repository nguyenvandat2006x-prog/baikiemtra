package vn.nguyenvandat.datestate.dto;

import vn.nguyenvandat.datestate.constant.ValidationRules;
import vn.nguyenvandat.datestate.enums.LoaiDichVu;
import vn.nguyenvandat.datestate.validation.MaGiaoDichHopLe;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GiaoDichForm {

    @NotBlank
    @MaGiaoDichHopLe
    private String maGiaoDich;

    @NotNull
    private Long maKhachHang;

    @NotNull
    private LoaiDichVu loaiDichVu;

    @NotNull
    @Future(groups = TaoMoi.class)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate ngayGiaoDich;

    @NotNull
    @DecimalMin(value = ValidationRules.DON_GIA_TOI_THIEU, inclusive = false)
    private BigDecimal donGia;

    @NotNull
    @DecimalMin(value = ValidationRules.DIEN_TICH_TOI_THIEU, inclusive = false)
    private BigDecimal dienTich;

    public interface TaoMoi extends Default {
    }

    public String getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(String maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public Long getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(Long maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public LoaiDichVu getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public LocalDate getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal getDienTich() {
        return dienTich;
    }

    public void setDienTich(BigDecimal dienTich) {
        this.dienTich = dienTich;
    }
}
