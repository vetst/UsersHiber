<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>Список пользователей</h2>

<table border="1" cellpadding="5" cellspacing="5">
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.name} ${user.surName}</td>
            <td>
                <form action="edit" method="GET">
                    <input type="hidden" name="userId" value="${user.id}">
                    <input type="submit" value="Редактировать"/>
                </form>
            </td>
            <td>
                <form action="delete" method="GET">
                    <input type="hidden" name="userId" value="${user.id}">
                    <input type="submit" value="Удалить"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<h2>Добавить пользователя</h2>
<form action="main" method="POST">
    <p><input type="text" name="name" placeholder="Имя" required></p>
    <p><input type="text" name="surName" placeholder="Фамилия" required></p>
    <input type="submit" value="Добавить"/></form>
</body>
</html>