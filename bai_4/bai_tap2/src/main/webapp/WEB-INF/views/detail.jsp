
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thông tin tờ khai y tế</title>

    <style>
        * { box-sizing: border-box; }

        body {
            margin: 0;
            padding: 30px 15px;
            font-family: Arial, sans-serif;
            background: #f1f5f9;
            color: #334155;
        }

        .container {
            max-width: 850px;
            margin: auto;
            padding: 30px;
            background: white;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,.08);
        }

        h1 {
            text-align: center;
            color: #0d6efd;
            margin-bottom: 10px;
        }

        .description {
            text-align: center;
            color: #64748b;
            margin-bottom: 30px;
        }

        .section-title {
            margin: 25px 0 15px;
            padding-bottom: 10px;
            border-bottom: 2px solid #0d6efd;
            color: #0d6efd;
            font-size: 19px;
        }

        .info-row {
            display: flex;
            justify-content: space-between;
            gap: 20px;
            padding: 13px 0;
            border-bottom: 1px solid #e2e8f0;
        }

        .info-label {
            font-weight: bold;
            color: #475569;
            width: 40%;
        }

        .info-value {
            width: 60%;
            text-align: right;
            overflow-wrap: anywhere;
        }

        .answer {
            display: inline-block;
            padding: 5px 13px;
            border-radius: 20px;
            background: #e0f2fe;
            color: #0369a1;
            font-size: 13px;
            font-weight: bold;
        }

        .actions {
            display: flex;
            gap: 12px;
            margin-top: 30px;
        }

        .btn {
            flex: 1;
            padding: 13px;
            text-align: center;
            text-decoration: none;
            border-radius: 6px;
            font-weight: bold;
        }

        .btn-edit {
            background: #0d6efd;
            color: white;
        }

        .btn-edit:hover { background: #0b5ed7; }

        .btn-home {
            background: #e2e8f0;
            color: #334155;
        }

        .btn-home:hover { background: #cbd5e1; }

        @media (max-width: 600px) {
            .container { padding: 20px; }
            .info-row { flex-direction: column; gap: 6px; }
            .info-label, .info-value {
                width: 100%;
                text-align: left;
            }
            .actions { flex-direction: column; }
        }
    </style>
</head>

<body>

<div class="container">
    <h1>THÔNG TIN TỜ KHAI Y TẾ</h1>
    <p class="description">
        Thông tin bạn đã gửi được hiển thị bên dưới.
    </p>
    <h3 class="section-title">I. Thông tin cá nhân</h3>
    <div class="info-row">
        <span class="info-label">Họ và tên</span>
        <span class="info-value">${declaration.fullName}</span>
    </div>
    <div class="info-row">
        <span class="info-label">Năm sinh</span>
        <span class="info-value">${declaration.birthYear}</span>
    </div>
    <div class="info-row">
        <span class="info-label">Giới tính</span>
        <span class="info-value">${declaration.gender}</span>
    </div>
    <div class="info-row">
        <span class="info-label">Quốc tịch</span>
        <span class="info-value">${declaration.nationality}</span>
    </div>
    <div class="info-row">
        <span class="info-label">Số hộ chiếu / CMND / CCCD</span>
        <span class="info-value">${declaration.identityNumber}</span>
    </div>
    <h3 class="section-title">II. Thông tin đi lại</h3>
    <div class="info-row">
        <span class="info-label">Phương tiện di chuyển</span>
        <span class="info-value">${declaration.travelType}</span>
    </div>
    <div class="info-row">
        <span class="info-label">Số hiệu phương tiện</span>
        <span class="info-value">${empty declaration.vehicleNumber ? 'Không có' : declaration.vehicleNumber}</span>
    </div>
    <div class="info-row">
        <span class="info-label">Số ghế</span>
        <span class="info-value">${empty declaration.seatNumber ? 'Không có' : declaration.seatNumber}</span>
    </div>
    <div class="info-row">
        <span class="info-label">Ngày khởi hành</span>
        <span class="info-value">${declaration.departureDate}</span>
    </div>
    <div class="info-row">
        <span class="info-label">Ngày trở về</span>
        <span class="info-value">${declaration.returnDate}</span>
    </div>
    <h3 class="section-title">III. Thông tin liên hệ</h3>
    <div class="info-row">
        <span class="info-label">Tỉnh / Thành phố</span>
        <span class="info-value">${declaration.province}</span>
    </div>
    <div class="info-row">
        <span class="info-label">Quận / Huyện</span>
        <span class="info-value">${declaration.district}</span>
    </div>
    <div class="info-row">
        <span class="info-label">Phường / Xã</span>
        <span class="info-value">${declaration.ward}</span>
    </div>
    <div class="info-row">
        <span class="info-label">Địa chỉ cụ thể</span>
        <span class="info-value">${declaration.address}</span>
    </div>
    <div class="info-row">
        <span class="info-label">Số điện thoại</span>
        <span class="info-value">${declaration.phone}</span>
    </div>
    <div class="info-row">
        <span class="info-label">Email</span>
        <span class="info-value">${declaration.email}</span>
    </div>
    <h3 class="section-title">IV. Triệu chứng</h3>
    <div class="info-row">
        <span class="info-label">Sốt</span>
        <span class="info-value"><span class="answer">${declaration.fever ? 'Có' : 'Không'}</span></span>
    </div>
    <div class="info-row">
        <span class="info-label">Ho</span>
        <span class="info-value"><span class="answer">${declaration.cough ? 'Có' : 'Không'}</span></span>
    </div>
    <div class="info-row">
        <span class="info-label">Khó thở</span>
        <span class="info-value"><span class="answer">${declaration.difficultyBreathing ? 'Có' : 'Không'}</span></span>
    </div>
    <div class="info-row">
        <span class="info-label">Đau họng</span>
        <span class="info-value"><span class="answer">${declaration.soreThroat ? 'Có' : 'Không'}</span></span>
    </div>
    <div class="info-row">
        <span class="info-label">Buồn nôn</span>
        <span class="info-value"><span class="answer">${declaration.nausea ? 'Có' : 'Không'}</span></span>
    </div>
    <div class="info-row">
        <span class="info-label">Tiêu chảy</span>
        <span class="info-value"><span class="answer">${declaration.diarrhea ? 'Có' : 'Không'}</span></span>
    </div>
    <div class="info-row">
        <span class="info-label">Xuất huyết ngoài da</span>
        <span class="info-value"><span class="answer">${declaration.skinHemorrhage ? 'Có' : 'Không'}</span></span>
    </div>
    <div class="info-row">
        <span class="info-label">Phát ban ngoài da</span>
        <span class="info-value"><span class="answer">${declaration.skinRash ? 'Có' : 'Không'}</span></span>
    </div>
    <h3 class="section-title">V. Lịch sử dịch tễ</h3>
    <div class="info-row">
        <span class="info-label">Tiếp xúc với động vật</span>
        <span class="info-value"><span class="answer">${declaration.contactWithAnimals ? 'Có' : 'Không'}</span></span>
    </div>
    <div class="info-row">
        <span class="info-label">Tiếp xúc với người nhiễm bệnh</span>
        <span class="info-value"><span class="answer">${declaration.contactWithInfectedPerson ? 'Có' : 'Không'}</span></span>
    </div>
    <div class="info-row">
        <span class="info-label">Đã đến khu vực có dịch</span>
        <span class="info-value"><span class="answer">${declaration.visitedEpidemicArea ? 'Có' : 'Không'}</span></span>
    </div>
    <div class="actions">
        <a href="${pageContext.request.contextPath}/" class="btn btn-edit">
            Cập nhật thông tin
        </a>
    </div>
</div>
</body>
</html>
