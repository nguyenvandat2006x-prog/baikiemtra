package vn.nguyenvandat.datestate.service.impl;

import vn.nguyenvandat.datestate.constant.Messages;
import vn.nguyenvandat.datestate.dto.GiaoDichDetail;
import vn.nguyenvandat.datestate.dto.GiaoDichForm;
import vn.nguyenvandat.datestate.dto.GiaoDichListItem;
import vn.nguyenvandat.datestate.dto.GiaoDichSearchCriteria;
import vn.nguyenvandat.datestate.entity.GiaoDich;
import vn.nguyenvandat.datestate.entity.KhachHang;
import vn.nguyenvandat.datestate.exception.DuplicateResourceException;
import vn.nguyenvandat.datestate.exception.ResourceNotFoundException;
import vn.nguyenvandat.datestate.mapper.GiaoDichMapper;
import vn.nguyenvandat.datestate.repository.GiaoDichRepository;
import vn.nguyenvandat.datestate.repository.KhachHangRepository;
import vn.nguyenvandat.datestate.service.GiaoDichService;
import vn.nguyenvandat.datestate.specification.GiaoDichSpecification;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class GiaoDichServiceImpl implements GiaoDichService {

    private static final Sort SAP_XEP_THEO_MA = Sort.by(Sort.Direction.ASC, "maGiaoDich");

    private final GiaoDichRepository giaoDichRepository;
    private final KhachHangRepository khachHangRepository;
    private final GiaoDichMapper giaoDichMapper;

    public GiaoDichServiceImpl(GiaoDichRepository giaoDichRepository,
                               KhachHangRepository khachHangRepository,
                               GiaoDichMapper giaoDichMapper) {
        this.giaoDichRepository = giaoDichRepository;
        this.khachHangRepository = khachHangRepository;
        this.giaoDichMapper = giaoDichMapper;
    }

    @Override
    public List<GiaoDichListItem> timKiem(GiaoDichSearchCriteria criteria) {
        return giaoDichRepository
                .findAll(GiaoDichSpecification.theoTieuChi(criteria), SAP_XEP_THEO_MA)
                .stream()
                .map(giaoDichMapper::toListItem)
                .toList();
    }

    @Override
    public GiaoDichDetail layChiTiet(String maGiaoDich) {
        GiaoDich giaoDich = giaoDichRepository.findById(maGiaoDich)
                .orElseThrow(() -> khongTimThayGiaoDich(maGiaoDich));
        return giaoDichMapper.toDetail(giaoDich);
    }

    @Override
    public GiaoDichForm layFormCapNhat(String maGiaoDich) {
        GiaoDich giaoDich = giaoDichRepository.findById(maGiaoDich)
                .orElseThrow(() -> khongTimThayGiaoDich(maGiaoDich));
        return giaoDichMapper.toForm(giaoDich);
    }

    @Override
    @Transactional
    public void themMoi(GiaoDichForm form) {
        if (giaoDichRepository.existsById(form.getMaGiaoDich())) {
            throw new DuplicateResourceException(String.format(Messages.GIAO_DICH_DA_TON_TAI, form.getMaGiaoDich()));
        }
        KhachHang khachHang = khachHangRepository.findById(form.getMaKhachHang())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(Messages.KHACH_HANG_KHONG_TON_TAI, form.getMaKhachHang())));
        giaoDichRepository.save(giaoDichMapper.toEntity(form, khachHang));
    }

    @Override
    @Transactional
    public void capNhat(String maGiaoDich, GiaoDichForm form) {
        GiaoDich giaoDich = giaoDichRepository.findById(maGiaoDich)
                .orElseThrow(() -> khongTimThayGiaoDich(maGiaoDich));
        KhachHang khachHang = khachHangRepository.findById(form.getMaKhachHang())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(Messages.KHACH_HANG_KHONG_TON_TAI, form.getMaKhachHang())));
        giaoDichMapper.capNhatThongTin(giaoDich, form, khachHang);
        giaoDichRepository.save(giaoDich);
    }

    @Override
    @Transactional
    public void xoa(String maGiaoDich) {
        if (!giaoDichRepository.existsById(maGiaoDich)) {
            throw khongTimThayGiaoDich(maGiaoDich);
        }
        giaoDichRepository.deleteById(maGiaoDich);
    }

    private ResourceNotFoundException khongTimThayGiaoDich(String maGiaoDich) {
        return new ResourceNotFoundException(String.format(Messages.GIAO_DICH_KHONG_TON_TAI, maGiaoDich));
    }
}
