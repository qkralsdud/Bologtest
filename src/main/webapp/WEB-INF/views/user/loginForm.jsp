<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form class="form-inline" action="/login" method="post">
  <label for="username">username: </label>
  <input type="text" class="form-control" placeholder="Enter username"  name="username">&nbsp;&nbsp;
  <label for="Password">Password:</label>
  <input type="password" class="form-control" placeholder="Enter password"  name="password">
  <button type="submit" class="btn btn-primary">로그인</button>
</form>
</div>

<%@ include file="../layout/footer.jsp" %>


    