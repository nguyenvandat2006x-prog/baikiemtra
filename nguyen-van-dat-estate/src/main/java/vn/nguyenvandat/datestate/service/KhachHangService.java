package vn.nguyenvandat.datestate.service;

import vn.nguyenvandat.datestate.dto.KhachHangForm;
import vn.nguyenvandat.datestate.dto.KhachHangOption;

import java.util.List;

public interface KhachHangService {

    List<KhachHangOption> layDanhSach();

    void themMoi(KhachHangForm form);

    boolean daTonTaiSoDienThoai(String soDienThoai);

    boolean daTonTaiEmail(String email);
}
