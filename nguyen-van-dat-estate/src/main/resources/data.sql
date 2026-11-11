INSERT INTO khach_hang (ten_khach_hang, so_dien_thoai, email) VALUES
    ('Nguyễn Văn A', '0905973155', 'nguyenvana@gmail.com'),
    ('Nguyễn Văn B', '0905123456', 'nguyenvanb@gmail.com'),
    ('Nguyễn Văn C', '0935987654', 'nguyenvanc@gmail.com'),
    ('Trần Thị Mai', '0912345678', 'tranthimai@gmail.com'),
    ('Lê Minh Quân', '0987654321', 'leminhquan@gmail.com');

INSERT INTO giao_dich (ma_giao_dich, ma_khach_hang, ngay_giao_dich, loai_dich_vu, don_gia, dien_tich) VALUES
    ('MGD-0001', 1, '2020-12-12', 'NHA_DAT', 2000000, 100),
    ('MGD-0002', 2, '2020-12-12', 'DAT', 3000000, 200),
    ('MGD-0003', 3, '2020-12-12', 'NHA_DAT', 5000000, 100),
    ('MGD-0004', 4, '2021-03-20', 'DAT', 1800000, 150),
    ('MGD-0005', 5, '2021-06-05', 'NHA_DAT', 7500000, 85),
    ('MGD-0006', 1, '2021-09-18', 'DAT', 2500000, 120);
