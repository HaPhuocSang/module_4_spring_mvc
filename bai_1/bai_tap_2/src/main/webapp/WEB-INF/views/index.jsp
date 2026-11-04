<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            width: 450px;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #2563eb;
            margin-bottom: 10px;
        }

        .description {
            text-align: center;
            color: #64748b;
            margin-bottom: 25px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 8px;
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
            padding: 12px;
            margin-top: 20px;
            border: none;
            border-radius: 6px;
            background: #2563eb;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background: #1d4ed8;
        }

        .result {
            margin-top: 25px;
            padding: 18px;
            background: #dcfce7;
            border-radius: 8px;
            color: #166534;
        }

        .error {
            margin-top: 20px;
            padding: 15px;
            background: #fee2e2;
            border-radius: 8px;
            color: #b91c1c;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>English - Vietnamese Dictionary</h2>
    <p class="description">
        Tra cứu từ điển Anh - Việt
    </p>
    <form action="${pageContext.request.contextPath}/" method="post">
        <label for="word">Nhập từ tiếng Anh:</label>
        <input type="text" id="word" name="word" placeholder="Ví dụ: hello, book, computer..." value="${word}" required>
        <button type="submit">Tra cứu</button>
    </form>
    <c:if test="${not empty meaning}">
        <div class="result">
            <h3>Kết quả tra cứu</h3>
            <p>Từ tiếng Anh:<strong>${word}</strong></p>
            <p>Nghĩa tiếng Việt: ${meaning}</p>
        </div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="error">
                ${error}
        </div>
    </c:if>
</div>
</body>
</html>