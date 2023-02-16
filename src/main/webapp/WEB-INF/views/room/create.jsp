<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/room/create" method="post">
  <table border="1"style="border-collapse: collapse">
    <tr>
      <th>ID</th>
      <td><input type="number" name="id"></td>
    </tr>
    <tr>
      <th>Name</th>
      <td><input type="text"name="name"></td>
    </tr>
    <tr>
      <td colspan="2" style="text-align: center"><button>Create</button></td>
    </tr>
  </table>
</form>
</body>
</html>
