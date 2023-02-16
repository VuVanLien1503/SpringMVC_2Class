<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShowList</title>
</head>
<body>
<h1>ListRoom</h1>
<h1><a href="/room/create"> Create New Room</a></h1>
<table border="1">
    <tr>
        <th>Stt</th>
        <th>Name</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach items="${room}" var="element" varStatus="stt">
        <tr>
            <td>${stt.index+1}</td>
            <td>${element.name}</td>
            <td><a href="/room/edit?id=${element.id}">Edit</a></td>
            <td><a href="/room/edit?id=${element.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<span style="margin-top: 50px;margin-left: 200px"><a href="/employee/display">Back To ListEmployee</a></span>
</body>
</html>
