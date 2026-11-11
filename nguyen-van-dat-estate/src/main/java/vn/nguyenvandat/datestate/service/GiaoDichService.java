package vn.nguyenvandat.datestate.service;

import vn.nguyenvandat.datestate.dto.GiaoDichDetail;
import vn.nguyenvandat.datestate.dto.GiaoDichForm;
import vn.nguyenvandat.datestate.dto.GiaoDichListItem;
import vn.nguyenvandat.datestate.dto.GiaoDichSearchCriteria;

import java.util.List;

public interface GiaoDichService {

    List<GiaoDichListItem> timKiem(GiaoDichSearchCriteria criteria);

    GiaoDichDetail layChiTiet(String maGiaoDich);

    GiaoDichForm layFormCapNhat(String maGiaoDich);

    void themMoi(GiaoDichForm form);

    void capNhat(String maGiaoDich, GiaoDichForm form);

    void xoa(String maGiaoDich);
}
