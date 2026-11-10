<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            display: flex;
            justify-content: center;
            padding-top: 80px;
        }

        .container {
            width: 450px;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 3px 12px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            color: #333;
        }

        label {
            display: block;
            margin: 20px 0 8px;
            font-weight: bold;
        }

        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        textarea {
            width: 100%;
            height: 100px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
            font-size: 14px;
            resize: vertical;
        }

        textarea:focus {
            outline: none;
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0, 123, 255, 0.2);
        }

        button {
            width: 100%;
            padding: 12px;
            margin-top: 25px;
            background: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Email Settings</h2>
    <form:form action="${pageContext.request.contextPath}/edit" method="post" modelAttribute="emailSettings">
        <label>Languages</label>
        <form:select path="languageId">
            <form:options items="${languages}" itemValue="id" itemLabel="name"/>
        </form:select>
        <label>Page Size</label>
        <form:select path="pageSize">
            <form:options items="${pageSizes}"/>
        </form:select>
        <label>Spam Filter</label>
        <form:checkbox path="spamFilter"/>
        Enable spam filter
        <label>Signature</label>
        <form:textarea path="signature"/>
        <button type="submit">Submit</button>
    </form:form>
</div>
</body>
</html>
