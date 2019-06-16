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
<title>ユーザー登録</title>
</head>
<body>
	<div class="container">
		<div class="resume-section p-3 p-lg-5 d-flex flex-column">
			<c:import url="header/header.jsp" />
			<h3 class="mb-5" style="color: #957bbe;">
				<i class="fab fa-buromobelexperte"></i> EVENT SYSTEM
			</h3>
			<div class="resume-item d-flex flex-column flex-md-row mb-5">
				<div class="resume-content mr-auto">
					<div class="subheading mb-3"><i class="far fa-address-card"></i> ユーザ編集</div>
					<p>このページはイベントの内容の編集。</p>
				</div>
				<div class="resume-date text-md-right">
					<span class="text-primary">JUNE 2019 - MIE</span>
				</div>
			</div>
			<form:form modelAttribute="user" enctype="multipart/form-data">
				<div class="row">
					<div class="col">
						<div class="form-group">
							<img width="15%"
								class="img-fluid img-profile rounded-circle mx-auto mb-2"
								src="${pageContext.request.contextPath}/uploads/<c:out value="${user.img}" />">
						</div>
					</div>
				</div>

				<div class="row mb-4">
					<div class="col">
						<div class="form-group">
							<p>
								<strong>氏名(必須)</strong>
							</p>
							<form:input path="userName" cssClass="form-control"
								placeholder="氏名" />
							<form:errors path="userName" cssClass="form-control alert-danger" />
						</div>
						<div class="form-group">
							<p>
								<strong>ログインID(必須)</strong>
							</p>
							<form:input path="loginId" cssClass="form-control"
								placeholder="ログインID" />
							<form:errors path="loginId" cssClass="form-control alert-danger" />
						</div>
						<div class="form-group">
							<p>
								<strong>パスワード(変更の場合のみ)</strong>
							</p>
							<form:password name="passNew" path="" cssClass="form-control"
								placeholder="パスワード" />
							<form:hidden path="pass" />
							<form:errors path="pass" cssClass="form-control alert-danger" />
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<p>
								<strong>ユーザー種別</strong>
							</p>
							<c:choose>
								<c:when test="${user.userId == userId }">
									<form:select path="type.typeId" items="${type }"
										itemLabel="typeName" itemValue="typeId"
										cssClass="form-control" disabled="true">
									</form:select>
									<form:hidden path="type.typeId" />
								</c:when>
								<c:otherwise>
									<form:select path="type.typeId" items="${type }"
										itemLabel="typeName" itemValue="typeId"
										cssClass="form-control">
									</form:select>
								</c:otherwise>
							</c:choose>
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
						<form:hidden path="img" />
						<form:hidden path="userId" />
					</div>
				</div>

				<div class="row">
					<div class="col">
						<p>
							<input type="submit" value="保存" class="btn btn-primary">
							<a href="../detailsUser/<c:out value="${user.userId}" />"
								class="btn btn-secondary">キャンセル</a>
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