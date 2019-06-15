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
<title>イベント登録</title>
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
					<div class="subheading mb-3">イベント登録</div>
					<p>このページはイベント内容の登録。</p>
				</div>
				<div class="resume-date text-md-right">
					<span class="text-primary">JUNE 2019 - MIE</span>
				</div>
			</div>
			<form:form modelAttribute="event">
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<p>
								<strong>タイトル(必須)</strong>
							</p>
							<form:input path="title" cssClass="form-control"
								placeholder="例：Swiftの勉強会" required="required" />
							<form:errors path="title" cssClass="form-control alert-danger" />
						</div>
						<div class="form-group">
							<p>
								<strong>開始日時(必須)</strong>
							</p>
							<input type="datetime-local" step="300" name="startDate"
								class="form-control" required="required">
						</div>
						<div class="form-group">
							<p>
								<strong>終了日時(必須)</strong>
							</p>
							<input type="datetime-local" step="300" name="endDate"
								class="form-control" required="required"
								pattern="yyyy-MM-dd HH:mm:ss">
						</div>
						<div class="form-group">
							<p>
								<strong>場所(必須)</strong>
							</p>
							<form:input path="place" cssClass="form-control" placeholder=""
								required="required" />
							<form:errors path="place" cssClass="form-control alert-danger" />
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
								<strong>詳細</strong>
							</p>
							<form:textarea path="details" cssClass="form-control"
								placeholder="" />
						</div>
						<p>
							<form:hidden path="user.userId" />
							<a href="eventList" class="btn btn-secondary">キャンセル</a> <input
								type="submit" value="登録" class="btn btn-primary">
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