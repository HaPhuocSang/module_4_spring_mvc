
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Khai báo y tế</title>
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
            margin: 25px 0 18px;
            padding-bottom: 10px;
            border-bottom: 2px solid #0d6efd;
            color: #0d6efd;
            font-size: 19px;
        }

        .form-group { margin-bottom: 18px; }

        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 8px;
        }

        input[type="text"],
        input[type="number"],
        input[type="date"],
        input[type="email"],
        select {
            width: 100%;
            padding: 11px;
            border: 1px solid #cbd5e1;
            border-radius: 6px;
            font-size: 15px;
        }

        .radio-group {
            display: flex;
            gap: 25px;
            align-items: center;
        }

        .radio-group label {
            display: inline-flex;
            align-items: center;
            gap: 6px;
            margin: 0;
            font-weight: normal;
        }

        .question {
            display: flex;
            justify-content: space-between;
            align-items: center;
            gap: 15px;
            padding: 13px 0;
            border-bottom: 1px solid #e2e8f0;
        }

        .question-title { margin: 0; }

        .error {
            display: block;
            color: #dc3545;
            font-size: 13px;
            margin-top: 6px;
        }

        .btn-submit {
            width: 100%;
            padding: 13px;
            margin-top: 25px;
            background: #0d6efd;
            border: none;
            border-radius: 6px;
            color: white;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
        }

        .btn-submit:hover { background: #0b5ed7; }

        @media (max-width: 600px) {
            .container { padding: 20px; }
            .question {
                align-items: flex-start;
                flex-direction: column;
            }
        }
    </style>
</head>
<body>

<div class="container">
    <h1>TỜ KHAI Y TẾ</h1>
    <p class="description">
        Vui lòng cung cấp đầy đủ thông tin theo mẫu dưới đây.
    </p>
    <form:form method="post" action="${pageContext.request.contextPath}/submit" modelAttribute="declaration">
        <h3 class="section-title">I. Thông tin cá nhân</h3>
        <div class="form-group">
            <label>Họ và tên</label>
            <form:input path="fullName" placeholder="Nhập họ và tên"/>
            <form:errors path="fullName" cssClass="error"/>
        </div>
        <div class="form-group">
            <label>Năm sinh</label>
            <form:input path="birthYear" type="number" placeholder="Ví dụ: 2000"/>
            <form:errors path="birthYear" cssClass="error"/>
        </div>
        <div class="form-group">
            <label>Giới tính</label>
            <form:select path="gender">
                <form:option value="" label="-- Chọn giới tính --"/>
                <form:option value="Nam" label="Nam"/>
                <form:option value="Nữ" label="Nữ"/>
                <form:option value="Khác" label="Khác"/>
            </form:select>
            <form:errors path="gender" cssClass="error"/>
        </div>
        <div class="form-group">
            <label>Quốc tịch</label>
            <form:input path="nationality" placeholder="Nhập quốc tịch"/>
            <form:errors path="nationality" cssClass="error"/>
        </div>
        <div class="form-group">
            <label>Số hộ chiếu / CMND / CCCD</label>
            <form:input path="identityNumber" placeholder="Nhập số giấy tờ"/>
            <form:errors path="identityNumber" cssClass="error"/>
        </div>
        <h3 class="section-title">II. Thông tin đi lại</h3>
        <div class="form-group">
            <label>Phương tiện di chuyển</label>
            <form:select path="travelType">
                <form:option value="" label="-- Chọn phương tiện --"/>
                <form:option value="Máy bay"/>
                <form:option value="Tàu hỏa"/>
                <form:option value="Ô tô"/>
                <form:option value="Xe khách"/>
                <form:option value="Khác"/>
            </form:select>
            <form:errors path="travelType" cssClass="error"/>
        </div>
        <div class="form-group">
            <label>Số hiệu phương tiện</label>
            <form:input path="vehicleNumber" placeholder="Nhập số hiệu phương tiện"/>
            <form:errors path="vehicleNumber" cssClass="error"/>
        </div>
        <div class="form-group">
            <label>Số ghế</label>
            <form:input path="seatNumber" placeholder="Nhập số ghế"/>
            <form:errors path="seatNumber" cssClass="error"/>
        </div>
        <div class="form-group">
            <label>Ngày khởi hành</label>
            <form:input path="departureDate" type="date"/>
            <form:errors path="departureDate" cssClass="error"/>
        </div>
        <div class="form-group">
            <label>Ngày trở về</label>
            <form:input path="returnDate" type="date"/>
            <form:errors path="returnDate" cssClass="error"/>
        </div>
        <h3 class="section-title">III. Thông tin liên hệ</h3>
        <div class="form-group">
            <label>Tỉnh / Thành phố</label>
            <form:input path="province" placeholder="Nhập tỉnh hoặc thành phố"/>
            <form:errors path="province" cssClass="error"/>
        </div>
        <div class="form-group">
            <label>Quận / Huyện</label>
            <form:input path="district" placeholder="Nhập quận hoặc huyện"/>
            <form:errors path="district" cssClass="error"/>
        </div>
        <div class="form-group">
            <label>Phường / Xã</label>
            <form:input path="ward" placeholder="Nhập phường hoặc xã"/>
            <form:errors path="ward" cssClass="error"/>
        </div>
        <div class="form-group">
            <label>Địa chỉ cụ thể</label>
            <form:input path="address" placeholder="Số nhà, tên đường..."/>
            <form:errors path="address" cssClass="error"/>
        </div>
        <div class="form-group">
            <label>Số điện thoại</label>
            <form:input path="phone" placeholder="Nhập số điện thoại"/>
            <form:errors path="phone" cssClass="error"/>
        </div>
        <div class="form-group">
            <label>Email</label>
            <form:input path="email" type="email" placeholder="example@gmail.com"/>
            <form:errors path="email" cssClass="error"/>
        </div>
        <h3 class="section-title">IV. Triệu chứng</h3>
        <p>Trong thời gian gần đây, bạn có xuất hiện các triệu chứng sau không?</p>
        <div class="question">
            <span class="question-title">Sốt</span>
            <div class="radio-group">
                <label><form:radiobutton path="fever" value="true"/> Có</label>
                <label><form:radiobutton path="fever" value="false"/> Không</label>
            </div>
        </div>
        <form:errors path="fever" cssClass="error"/>
        <div class="question">
            <span class="question-title">Ho</span>
            <div class="radio-group">
                <label><form:radiobutton path="cough" value="true"/> Có</label>
                <label><form:radiobutton path="cough" value="false"/> Không</label>
            </div>
        </div>
        <form:errors path="cough" cssClass="error"/>
        <div class="question">
            <span class="question-title">Khó thở</span>
            <div class="radio-group">
                <label><form:radiobutton path="difficultyBreathing" value="true"/> Có</label>
                <label><form:radiobutton path="difficultyBreathing" value="false"/> Không</label>
            </div>
        </div>
        <form:errors path="difficultyBreathing" cssClass="error"/>
        <div class="question">
            <span class="question-title">Đau họng</span>
            <div class="radio-group">
                <label><form:radiobutton path="soreThroat" value="true"/> Có</label>
                <label><form:radiobutton path="soreThroat" value="false"/> Không</label>
            </div>
        </div>
        <form:errors path="soreThroat" cssClass="error"/>
        <div class="question">
            <span class="question-title">Buồn nôn</span>
            <div class="radio-group">
                <label><form:radiobutton path="nausea" value="true"/> Có</label>
                <label><form:radiobutton path="nausea" value="false"/> Không</label>
            </div>
        </div>
        <form:errors path="nausea" cssClass="error"/>
        <div class="question">
            <span class="question-title">Tiêu chảy</span>
            <div class="radio-group">
                <label><form:radiobutton path="diarrhea" value="true"/> Có</label>
                <label><form:radiobutton path="diarrhea" value="false"/> Không</label>
            </div>
        </div>
        <form:errors path="diarrhea" cssClass="error"/>
        <div class="question">
            <span class="question-title">Xuất huyết ngoài da</span>
            <div class="radio-group">
                <label><form:radiobutton path="skinHemorrhage" value="true"/> Có</label>
                <label><form:radiobutton path="skinHemorrhage" value="false"/> Không</label>
            </div>
        </div>
        <form:errors path="skinHemorrhage" cssClass="error"/>
        <div class="question">
            <span class="question-title">Phát ban ngoài da</span>
            <div class="radio-group">
                <label><form:radiobutton path="skinRash" value="true"/> Có</label>
                <label><form:radiobutton path="skinRash" value="false"/> Không</label>
            </div>
        </div>
        <form:errors path="skinRash" cssClass="error"/>
        <h3 class="section-title">V. Lịch sử dịch tễ</h3>
        <div class="question">
            <span class="question-title">Tiếp xúc với động vật</span>
            <div class="radio-group">
                <label><form:radiobutton path="contactWithAnimals" value="true"/> Có</label>
                <label><form:radiobutton path="contactWithAnimals" value="false"/> Không</label>
            </div>
        </div>
        <form:errors path="contactWithAnimals" cssClass="error"/>
        <div class="question">
            <span class="question-title">Tiếp xúc với người nhiễm bệnh</span>
            <div class="radio-group">
                <label><form:radiobutton path="contactWithInfectedPerson" value="true"/> Có</label>
                <label><form:radiobutton path="contactWithInfectedPerson" value="false"/> Không</label>
            </div>
        </div>
        <form:errors path="contactWithInfectedPerson" cssClass="error"/>
        <div class="question">
            <span class="question-title">Đã đến khu vực có dịch</span>
            <div class="radio-group">
                <label><form:radiobutton path="visitedEpidemicArea" value="true"/> Có</label>
                <label><form:radiobutton path="visitedEpidemicArea" value="false"/> Không</label>
            </div>
        </div>
        <form:errors path="visitedEpidemicArea" cssClass="error"/>
        <button type="submit" class="btn-submit">Gửi tờ khai</button>
    </form:form>
</div>
</body>
</html>
