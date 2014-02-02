<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>
      ユーザ明細
    </title>
  </head>
  <body>
    <form:form modelAttribute="userModel" action="${status == '2' ? 'create' : 'update'}" method="POST">
      <div>
        ユーザ明細
      </div>
      <c:if test="${status == '0' || status == '2'}">
        <input type="submit" value="登録">
      </c:if>
      <c:if test="${status == '0'}">
        <input type="submit" value="削除" name="delete">
      </c:if>
      <div>
        <a href="<c:url value="/users" ></c:url>">
          戻る
        </a>
      </div>
      <table border="1">
        <tr>
          <td>
            ユーザ名
          </td>
          <c:if test="${status == '0' || status == '1'}">
            <td>
              ${userModel.username}
              <form:hidden path="username"/>
            </td>
          </c:if>
          <c:if test="${status == '2'}">
            <td>
              <form:input path="username"/><form:errors path="username"/>
            </td>
          </c:if>
        </tr>
        <tr>
          <td>
            メールアドレス
          </td>
          <c:if test="${status == '1'}">
            <td>
              ${userModel.mailaddress}
            </td>
          </c:if>
          <c:if test="${status == '0' || status == '2'}">
            <td>
              <form:input path="mailaddress"/><form:errors path="mailaddress"/>
            </td>
          </c:if>
        </tr>
      </table>
    </form:form>
  </body>
</html>
