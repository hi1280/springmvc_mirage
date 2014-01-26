<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>サンプル</title>
</head>
<body>
<div>ユーザ明細</div>
<table border="1">
  <tr>
    <th>ユーザ名</th>
    <th>メールアドレス</th>
  </tr>
  <tr>
     <td>${user.username}</td>
     <td>${user.mailaddress}</td>
  </tr>
</table>
</body>
</html>