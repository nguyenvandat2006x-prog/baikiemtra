package vn.nguyenvandat.datestate.service.impl;

import vn.nguyenvandat.datestate.dto.KhachHangForm;
import vn.nguyenvandat.datestate.dto.KhachHangOption;
import vn.nguyenvandat.datestate.mapper.KhachHangMapper;
import vn.nguyenvandat.datestate.repository.KhachHangRepository;
import vn.nguyenvandat.datestate.service.KhachHangService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class KhachHangServiceImpl implements KhachHangService {

    private final KhachHangRepository khachHangRepository;
    private final KhachHangMapper khachHangMapper;

    public KhachHangServiceImpl(KhachHangRepository khachHangRepository, KhachHangMapper khachHangMapper) {
        this.khachHangRepository = khachHangRepository;
        this.khachHangMapper = khachHangMapper;
    }

    @Override
    public List<KhachHangOption> layDanhSach() {
        return khachHangRepository.findAllByOrderByTenKhachHangAsc()
                .stream()
                .map(khachHangMapper::toOption)
                .toList();
    }

    @Override
    @Transactional
    public void themMoi(KhachHangForm form) {
        khachHangRepository.save(khachHangMapper.toEntity(form));
    }

    @Override
    public boolean daTonTaiSoDienThoai(String soDienThoai) {
        return khachHangRepository.existsBySoDienThoai(soDienThoai.trim());
    }

    @Override
    public boolean daTonTaiEmail(String email) {
        return khachHangRepository.existsByEmailIgnoreCase(email.trim());
    }
}
