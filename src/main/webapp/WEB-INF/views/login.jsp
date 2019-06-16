<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="<spring:url value="/css/bootstrap.min.css" />"
	rel="stylesheet" />
<link href="<spring:url value="/css/all.min.css" />" rel="stylesheet" />
<link href="<spring:url value="/css/style.css" />" rel="stylesheet" />
<script src="<spring:url value="/js/jquery-2.2.4.min.js" />"></script>
<script src="<spring:url value="/js/bootstrap.min.js" />"></script>
<script src="<spring:url value="/js/all.js" />"></script>
<style>
html, body {
	height: 100%;
}

body {
	background-color: #F0E0F0 !important;
	padding-top: 0;
	padding-left: 0;
}
</style>
<title>ログイン</title>
</head>
<body class="text-center">
	<div class="container">
		<p class="text-danger">
			<form:errors path="user" />
		</p>
		<form:form modelAttribute="user" cssClass="form-signin">
			<form:hidden path="userName" value="tempName" />
			<div class="row">
				<div class="col-sm-12 text">
					<span style="font-size: 2.5em; color: #957bbe;"> <i
						class="fab fa-buromobelexperte"></i>
					</span>
					<h1 class="h3 mb-3 font-weight-normal">
						<strong>Event</strong> System
					</h1>
					<form:input path="loginId" type="text" cssClass="form-control"
						placeholder="LoginID"  required="required"/>

					<form:input path="pass" type="password" cssClass="form-control"
						placeholder="Password"  required="required"/>
					<p class="text-danger">
						<form:errors path="loginId" />
					</p>
					<p class="text-danger">
						<form:errors path="pass" />
					</p>

					<p>
						<input type="submit" value="ログイン"
							class="btn btn-lg btn-primary btn-block">
					</p>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>