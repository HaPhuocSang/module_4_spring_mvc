<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sandwich Condiments</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background: #f3f4f6;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            width: 100%;
            max-width: 500px;
            padding: 20px;
        }

        .card {
            background: white;
            padding: 35px;
            border-radius: 15px;
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.08);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 10px;
        }

        .subtitle {
            text-align: center;
            color: #888;
            margin-bottom: 30px;
        }

        h3 {
            color: #333;
            margin-bottom: 15px;
        }

        .checkbox-list {
            display: flex;
            flex-direction: column;
            gap: 12px;
            margin-bottom: 25px;
        }

        .checkbox-item {
            display: flex;
            align-items: center;
            gap: 12px;
            padding: 13px;
            border: 1px solid #ddd;
            border-radius: 8px;
            cursor: pointer;
            transition: 0.2s;
        }

        .checkbox-item:hover {
            background: #fff7ed;
            border-color: #f59e0b;
        }

        .checkbox-item input {
            width: 18px;
            height: 18px;
            accent-color: #f59e0b;
            cursor: pointer;
        }

        .checkbox-item span {
            color: #444;
            font-size: 15px;
        }

        button {
            width: 100%;
            padding: 13px;
            background: #f59e0b;
            color: white;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: 0.2s;
        }

        button:hover {
            background: #d97706;
        }

        .result {
            margin-top: 25px;
            padding: 20px;
            background: #fff7ed;
            border-radius: 10px;
            border-left: 4px solid #f59e0b;
        }

        .result h3 {
            color: #d97706;
        }

        .result ul {
            padding-left: 20px;
        }

        .result li {
            margin: 8px 0;
            color: #444;
        }

        .empty {
            color: #888;
            font-style: italic;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="card">
        <h1>🥪 Sandwich Order</h1>
        <p class="subtitle">Choose your favorite condiments</p>
        <form action="${pageContext.request.contextPath}/save" method="post">
            <h3>Select condiments:</h3>
            <div class="checkbox-list">
                <c:forEach var="spice" items="${spices}">
                    <label class="checkbox-item">
                        <input type="checkbox" name="condiments" value="${spice}">
                        <span>${spice}</span>
                    </label>
                </c:forEach>
            </div>
            <button type="submit">Submit</button>
        </form>
    </div>
    <c:if test="${submitted}">
        <c:if test="${not empty condiments}">
            <div class="result">
                <h3>Selected Condiments</h3>
                <ul>
                    <c:forEach var="condiment" items="${condiments}">
                        <li>${condiment}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>

        <c:if test="${empty condiments}">
            <div class="result">
                <p class="empty">
                    You haven't selected any condiments!
                </p>
            </div>
        </c:if>
    </c:if>
</div>
</body>
</html>