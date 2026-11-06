<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #667eea, #764ba2);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .container {
            width: 100%;
            max-width: 520px;
            background: white;
            padding: 35px;
            border-radius: 18px;
            box-shadow: 0 10px 35px rgba(0, 0, 0, 0.15);
        }

        .header {
            text-align: center;
            margin-bottom: 30px;
        }

        .header .icon {
            font-size: 45px;
            margin-bottom: 12px;
        }

        .header h1 {
            font-size: 24px;
            color: #333;
            margin-bottom: 10px;
        }

        .header p {
            font-size: 14px;
            color: #888;
        }

        .section-title {
            font-size: 17px;
            font-weight: bold;
            color: #333;
            margin-bottom: 18px;
        }

        .shift-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px;
            background: #f8f9fc;
            border: 1px solid #eee;
            border-radius: 10px;
            margin-bottom: 13px;
        }

        .shift-info {
            display: flex;
            align-items: center;
            gap: 12px;
        }

        .shift-icon {
            font-size: 25px;
            width: 42px;
            height: 42px;
            display: flex;
            align-items: center;
            justify-content: center;
            border-radius: 10px;
        }

        .morning {
            background: #fff0d9;
        }

        .afternoon {
            background: #fff8d9;
        }

        .evening {
            background: #e9e6ff;
        }

        .shift-info h3 {
            font-size: 15px;
            color: #333;
        }

        .shift-info p {
            font-size: 12px;
            color: #999;
            margin-top: 5px;
        }

        .input-group {
            display: flex;
            align-items: center;
            gap: 7px;
        }

        input[type="number"] {
            width: 75px;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 7px;
            outline: none;
            text-align: center;
            font-size: 15px;
        }

        input:focus, select:focus {
            border-color: #667eea;
        }

        .salary-section {
            margin-top: 25px;
        }

        select {
            width: 100%;
            padding: 13px;
            border: 1px solid #ddd;
            border-radius: 8px;
            outline: none;
            font-size: 14px;
            background: white;
        }

        .btn-submit {
            width: 100%;
            padding: 15px;
            margin-top: 25px;
            border: none;
            border-radius: 9px;
            background: linear-gradient(135deg, #667eea, #764ba2);
            color: white;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
        }

        .btn-submit:hover {
            opacity: 0.9;
        }

        /* Kết quả */

        .result {
            margin-top: 25px;
            padding: 20px;
            background: #f5f6ff;
            border-radius: 12px;
            border: 1px solid #e1e4ff;
        }

        .result h2 {
            color: #667eea;
            text-align: center;
            margin-bottom: 18px;
            font-size: 20px;
        }

        .result-row {
            display: flex;
            justify-content: space-between;
            padding: 12px 0;
            border-bottom: 1px solid #e5e5e5;
            font-size: 14px;
            color: #555;
        }

        .result-row strong {
            color: #333;
        }

        .total-salary {
            text-align: center;
            margin-top: 20px;
            padding: 18px;
            background: #667eea;
            border-radius: 10px;
            color: white;
        }

        .total-salary h3 {
            font-size: 14px;
            margin-bottom: 10px;
        }

        .total-salary p {
            font-size: 25px;
            font-weight: bold;
        }

        .footer {
            text-align: center;
            margin-top: 25px;
            color: #aaa;
            font-size: 12px;
        }

        @media (max-width: 480px) {
            .container {
                padding: 22px 15px;
            }

            .header h1 {
                font-size: 20px;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <div class="icon">💼</div>
        <h1>TÍNH LƯƠNG NHÂN VIÊN</h1>
        <p>Quản lý thời gian làm việc và thu nhập hàng tuần</p>
    </div>
    <form action="${pageContext.request.contextPath}/payrollCalculation" method="post">
        <div class="section-title">
            📅 Thời gian làm việc trong tuần
        </div>
        <div class="shift-item">
            <div class="shift-info">
                <div class="shift-icon morning">🌅</div>
                <div>
                    <h3>Ca sáng</h3>
                    <p>Buổi sáng</p>
                </div>
            </div>
            <div class="input-group">
                <label for="morningHours"></label>
                <input type="number" id="morningHours" name="morningHours" min="0" step="0.5" value="${morningHours}" placeholder="Nhập số giờ làm việc buổi sáng">
                <span>giờ</span>
            </div>
        </div>
        <div class="shift-item">
            <div class="shift-info">
                <div class="shift-icon afternoon">☀️</div>
                <div>
                    <h3>Ca chiều</h3>
                    <p>Buổi chiều</p>
                </div>
            </div>
            <div class="input-group">
                <label for="afternoonHours"></label>
                <input type="number" id="afternoonHours" name="afternoonHours" min="0" step="0.5" value="${afternoonHours}" placeholder="Nhập số giờ làm việc buổi chiều">
                <span>giờ</span>
            </div>
        </div>
        <div class="shift-item">
            <div class="shift-info">
                <div class="shift-icon evening">🌙</div>
                <div>
                    <h3>Ca tối</h3>
                    <p>Buổi tối</p>
                </div>
            </div>
            <div class="input-group">
                <label for="eveningHours"></label>
                <input type="number" id="eveningHours" name="eveningHours" min="0" value="${eveningHours}" step="0.5" placeholder="Nhập số giờ làm việc buổi tối">
                <span>giờ</span>
            </div>
        </div>
        <div class="salary-section">
            <div class="section-title">
                💰 Mức lương theo giờ
            </div>
            <label for="hourlySalary"></label>
            <select id="hourlySalary" name="hourlySalary" required>
                <c:forEach var="hourlyWage" items="${hourlyWages}">
                    <option value="${hourlyWage.salary}" ${hourlySalary == hourlyWage.salary ? 'selected' : ''}>${hourlyWage.description}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn-submit">
            Tính lương →
        </button>
    </form>
    <c:if test="${not empty totalSalary}">
        <div class="result">
            <h2>📊 KẾT QUẢ TÍNH LƯƠNG</h2>
            <div class="result-row">
                <span>🌅 Số giờ ca sáng</span>
                <strong>${morningHours} giờ</strong>
            </div>
            <div class="result-row">
                <span>☀️ Số giờ ca chiều</span>
                <strong>${afternoonHours} giờ</strong>
            </div>
            <div class="result-row">
                <span>🌙 Số giờ ca tối</span>
                <strong>${eveningHours} giờ</strong>
            </div>
            <div class="result-row">
                <span>⏱ Tổng số giờ</span>
                <strong>${totalHours} giờ</strong>
            </div>
            <div class="result-row">
                <span>💵 Lương theo giờ</span>
                <strong>${hourlySalary} VNĐ</strong>
            </div>
            <div class="total-salary">
                <h3>TỔNG THU NHẬP TRONG TUẦN</h3>
                <p>${totalSalary} VNĐ</p>
            </div>
        </div>
    </c:if>
    <div class="footer">
        © 2026 - Hệ thống tính lương nhân viên
    </div>
</div>
</body>
</html>