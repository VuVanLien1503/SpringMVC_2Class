<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>
<h1>List Employee</h1> <br><br>
<form action="/employee/search" method="post">
    <input type="text" name="search" placeholder="Enter Find By Name">
    <button>Search</button>
</form>
<h3><a href="/employee/create" style="margin-top: 20px;margin-left: 200px"> Create New Employee</a></h3>
<div>
    <table border="1" style="border-collapse: collapse ; margin-top: 20px" >
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Age</th>
            <th>Address</th>
            <th>Room</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach items="${list}" var="element" varStatus="stt">
            <tr>
                <td>${stt.index+1}</td>
                <td>${element.getName()}</td>
                <td>${element.getAge()}</td>
                <td>${element.getAddress()}</td>
                <td>${element.room.name}</td>
                <td><a href="/employee/edit?id=${element.id}">Edit</a></td>
                <td><a href="/employee/delete?id=${element.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div style="margin-top: 30px;margin-left: 30px">
    <div>
        <a href="/employee/display?page=${currentPage-1}" style="margin-right: 20px"><b>Back</b></a>
        <span style="color: red"> [ ${currentPage} ]</span>
        <a href="/employee/display?page=${currentPage+1}" style="margin-left: 20px"><b>Next</b></a>
        <a href="/employee/display?page=${totalPages+1}"><i>[${totalPages+1}]</i></a>
    </div>
</div>
<div style="margin-left: 200px;margin-top: 50px">
    <a href="/room/display">ListRoom</a>
</div>
</body>
</html>
