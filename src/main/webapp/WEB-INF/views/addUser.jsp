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
<title>ユーザ登録</title>
</head>
<body>
	<div class="container">
		<div class="resume-section p-3 p-lg-5 d-flex flex-column">
			<c:import url="header/header.jsp" />
			<h3 style="color: #957bbe;">
				<i class="fab fa-buromobelexperte"></i> EVENT SYSTEM
			</h3>
			<div class="resume-item d-flex flex-column flex-md-row mb-5">
				<div class="resume-content mr-auto">
					<div class="subheading mb-3">ユーザ登録</div>
					<p>このページはユーザ情報の登録。</p>
				</div>
				<div class="resume-date text-md-right">
					<span class="text-primary">JUNE 2019 - MIE</span>
				</div>
			</div>
			<form:form modelAttribute="user" enctype="multipart/form-data">
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<p>
								<strong>氏名(必須)</strong>
							</p>
							<form:input path="userName" cssClass="form-control"
								placeholder="氏名" required="required" />
							<form:errors path="userName" cssClass="form-control alert-danger" />
						</div>
						<div class="form-group">
							<p>
								<strong>ログインID(必須)</strong>
							</p>
							<form:input path="loginId" cssClass="form-control"
								placeholder="ログインID" required="required" />
							<form:errors path="loginId" cssClass="form-control alert-danger" />
						</div>
						<div class="form-group">
							<p>
								<strong>パスワード(必須)</strong>
							</p>
							<form:input path="pass" cssClass="form-control" type="password"
								placeholder="パスワード" required="required" />
							<form:errors path="pass" cssClass="form-control alert-danger" />
						</div>
						<div class="form-group">
							<p>
								<strong>ユーザ種別</strong>
							</p>
							<form:select path="type.typeId" items="${type }"
								itemLabel="typeName" itemValue="typeId" cssClass="form-control">
							</form:select>
						</div>
						<div class="form-group">
							<p>
								<strong>対象グループ</strong>
							</p>
							<form:select path="group.groupId" items="${group }"
								itemLabel="groupName" itemValue="groupId"
								cssClass="form-control">
							</form:select>
						</div>
						<div class="form-group">
							<p>
								<strong>ユーザ写真</strong>
							</p>
							<input type="file" name="file" class="form-control"
								placeholder="ユーザ写真" />
						</div>
						<p>
							<input type="submit" value="登録" class="btn btn-primary">
							<a href="userList" class="btn btn-secondary">キャンセル</a>
						</p>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<script src="<spring:url value="/js/jquery-2.2.4.min.js" />"></script>
	<script src="<spring:url value="/js/bootstrap.min.js" />"></script>
	<script src="<spring:url value="/js/all.js" />"></script>
</body>
</html>