<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>Удалить пользователя</h2>
<a href="main"><<< вернуться назад</a>
<p><c:out value="${message}"/><p>
<form action="delete" method="POST">
    <input type="hidden" name="userId" value="${userId}">
    <input type="submit" value="Удалить"/></form>
</body>
</html>