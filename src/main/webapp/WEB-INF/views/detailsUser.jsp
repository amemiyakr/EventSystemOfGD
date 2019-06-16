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
<title>ユーザ管理</title>
</head>
<body>
	<div class="container">
		<div class="resume-section p-3 p-lg-5 d-flex flex-column">
			<c:import url="header/header.jsp" />
			<h3 class="mb-5" style="color: #957bbe;">
				<i class="fab fa-buromobelexperte"></i> EVENT SYSTEM
			</h3>
			<div class="resume-item d-flex flex-column flex-md-row mb-3">
				<div class="resume-content mr-auto">
					<div class="subheading mb-3">
						<i class="far fa-address-card"></i> ユーザ詳細
					</div>
					<p>このページはユーザの情報を表示する。</p>
				</div>
				<div class="resume-date text-md-right">
					<span class="text-primary">JUNE 2019 - MIE</span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<table class="table table-striped mb-4">
						<tr>
							<th class="rounded-top border-top-0" colspan="2"
								style="background-color: #957bbe;"></th>
						</tr>
						<tr>
							<th class="text-center border-left border-right" colspan="2"><img
								width="30%"
								class="img-fluid img-profile rounded-circle mx-auto mb-2"
								src="${pageContext.request.contextPath}/uploads/<c:out value="${user.img}" />">
							</th>
						</tr>
						<tr>
							<th class="text-right border-left border-right">ID</th>
							<td class="text-left border-right"><c:out
									value="${user.userId}" /></td>
						</tr>
						<tr>
							<th class="text-right border-left border-right">氏名</th>
							<td class="text-left border-right"><c:out
									value="${user.userName}" /></td>
						</tr>
						<tr>
							<th class="text-right border-left border-right">ログインID</th>
							<td class="text-left border-right"><c:out
									value="${user.loginId}" /></td>
						</tr>
						<tr>
							<th class="text-right border-bottom  border-right border-left">グループ</th>
							<td class="text-left  border-bottom border-right"><c:out
									value="${user.group.groupName}" /></td>
						</tr>
						<tr>
							<th class="rounded-bottom border-bottom-0" colspan="2"
								style="background-color: #957bbe;"></th>
						</tr>
					</table>
					<a href="<spring:url value="/editUser/${user.userId}" />"
						class="btn btn-warning">編集</a> <a
						href="<spring:url value="/userList" />" class="btn btn-secondary">一覧に戻る</a>
					<c:if test="${user.userId != userId}">
						<button type="button" class="btn btn-danger" data-toggle="modal"
							data-target="#del">削除</button>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<!-- del -->
	<div class="modal fade" id="del" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">本当に削除してよろしいですか？</h5>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					<a href="<spring:url value="/delUser/${user.userId}" />"
						class="btn btn-danger">OK</a>
				</div>
			</div>
		</div>
	</div>
	<script src="<spring:url value="/js/jquery-2.2.4.min.js" />"></script>
	<script src="<spring:url value="/js/bootstrap.min.js" />"></script>
	<script src="<spring:url value="/js/all.js" />"></script>
</body>
</html>