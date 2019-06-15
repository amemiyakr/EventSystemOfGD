<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="<spring:url value="/css/bootstrap.min.css" />"
	rel="stylesheet" />
<link href="<spring:url value="/css/all.min.css" />" rel="stylesheet" />
<link href="<spring:url value="/css/style.css" />" rel="stylesheet" />
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
<title>イベント一覧</title>
</head>
<body class="text-center">
	<div class="container">
		<div class="row">
			<div class="col-sm-12 text">
				<h1 class="h3 mb-3 font-weight-normal">
					<strong>Event</strong> System
				</h1>
				<div class="col-md-12">
					<p>
						<a class="btn btn-light" href="login">ログイン画面</a>
					</p>
					<p>ご利用いただきありがとうございました。</p>
				</div>
			</div>
		</div>
	</div>
	<script src="<spring:url value="/js/jquery-2.2.4.min.js" />"></script>
	<script src="<spring:url value="/js/bootstrap.min.js" />"></script>
	<script src="<spring:url value="/js/all.js" />"></script>
</body>
</html>