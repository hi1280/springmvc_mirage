<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ一覧</title>
</head>
<body>
<div>ユーザ一覧</div>
<div><a href="<c:url value="/user/new" />">新規登録</a></div>
<table border="1">
  <tr>
    <th>ユーザ名</th>
    <th>メールアドレス</th>
    <th></th>
    <th></th>
  </tr>
  <c:forEach var="user" items="${userList}">
  <tr>
    <td>${user.username}</td>
    <td>${user.mailaddress}</td>
    <td><a href="<c:url value="/user" ><c:param name="username" value="${user.username}" /></c:url>">表示</a></td>
    <td><a href="<c:url value="/user/edit" ><c:param name="username" value="${user.username}" /></c:url>">編集</a></td>
  </tr>
  </c:forEach>
</table>
</body>
</html>