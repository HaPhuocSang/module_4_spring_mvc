<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background: #f1f5f9;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .container {
            width: 420px;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #2563eb;
        }

        label {
            display: block;
            margin-top: 18px;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 12px;
            border: 1px solid #cbd5e1;
            border-radius: 6px;
            font-size: 15px;
        }

        button {
            width: 100%;
            margin-top: 25px;
            padding: 12px;
            background: #2563eb;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background: #1d4ed8;
        }

        .result {
            margin-top: 20px;
            padding: 15px;
            background: #dcfce7;
            border-radius: 6px;
            color: #166534;
            text-align: center;
        }

        .error {
            margin-top: 15px;
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Chuyển đổi USD sang VNĐ</h2>
    <form action="${pageContext.request.contextPath}/" method="post">
        <label for="exchangeRate">Tỷ giá (VNĐ/USD):</label>
        <input type="number" name="exchangeRate" id="exchangeRate" placeholder="Nhập tỷ giá" min="0.01" step="any" value="${exchangeRate}" required>
        <label for="usdAmount">Số tiền USD:</label>
        <input type="number" name="usdAmount" id="usdAmount" placeholder="Nhập số USD" min="0" step="any" value="${usdAmount}" required>
        <button type="submit">Chuyển đổi</button>
    </form>
    <c:if test="${not empty error}">
        <div class="error">
                ${error}
        </div>
    </c:if>
    <c:if test="${not empty result}">
        <div class="result">
            <h3>Kết quả chuyển đổi</h3>
            <p>${usdAmount} USD</p>
            <p>Tỷ giá: ${exchangeRate} VNĐ/USD</p>
            <h2>${result} VNĐ</h2>
        </div>
    </c:if>
</div>
</body>
</html>