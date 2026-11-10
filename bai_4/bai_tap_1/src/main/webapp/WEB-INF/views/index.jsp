<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        body {
            font-family: Arial;
            background: #f4f6f9;
            padding: 40px;
        }

        .container {
            background: white;
            max-width: 600px;
            margin: auto;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px #ddd;
        }

        h2 {
            text-align: center;
        }

        .item {
            padding: 15px;
            border-bottom: 1px solid #eee;
        }

        .label {
            font-weight: bold;
            color: #555;
        }

        .message {
            padding: 12px 15px;
            margin: 20px 0;
            border-radius: 6px;
            font-size: 14px;
            text-align: center;
        }

        .message.success {
            color: #155724;
            background: #d4edda;
            border: 1px solid #c3e6cb;
        }

        .btn {
            display: block;
            text-align: center;
            background: #007bff;
            color: white;
            padding: 12px;
            margin-top: 25px;
            text-decoration: none;
            border-radius: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <c:if test="${not empty message}">
        <div class="message success">
                ${message}
        </div>
    </c:if>
    <h2>Email Settings</h2>
    <div class="item">
        <span class="label">Language:</span>
        <c:forEach var="language" items="${languages}">
            <c:if test="${language.id == emailSettings.languageId}">
                ${language.name}
            </c:if>
        </c:forEach>
    </div>
    <div class="item">
        <span class="label">Page Size:</span>
        ${emailSettings.pageSize} emails
    </div>
    <div class="item">
        <span class="label">Spam Filter:</span>
        <c:choose>
            <c:when test="${emailSettings.spamFilter}">
                Enabled
            </c:when>
            <c:otherwise>
                Disabled
            </c:otherwise>
        </c:choose>
    </div>
    <div class="item">
        <span class="label">Signature:</span>
        ${emailSettings.signature}
    </div>
    <a href="${pageContext.request.contextPath}/edit" class="btn">Setting</a>
</div>
</body>
</html>