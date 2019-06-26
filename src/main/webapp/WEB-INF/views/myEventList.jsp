<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="<spring:url value="/css/bootstrap.min.css" />"
	rel="stylesheet" />
<link href="<spring:url value="/css/all.min.css" />" rel="stylesheet" />
<link href="<spring:url value="/css/style.css" />" rel="stylesheet" />
<title>Myイベント</title>
</head>
<body>
	<div class="container">
		<div class="resume-section p-3 p-lg-5 d-flex flex-column">
			<c:import url="header/header.jsp" />
			<h3 class="mb-5" style="color: #957bbe;">
				<i class="fab fa-buromobelexperte"></i> EVENT SYSTEM
			</h3>
			<c:set value="${pagedListHolder}" var="createdList" />
			<c:url value="/myEventList" var="pagedLink">
				<c:param name="p" value="~" />
			</c:url>
			<div class="resume-item d-flex flex-column flex-md-row mb-5">
				<div class="resume-content mr-auto">
					<div class="subheading mb-3">
						<i class="fas fa-clipboard-list"></i> My イベント管理
					</div>
					<p>このページは該当ユーザ登録したイベントを表示する。</p>
					<p>
						<strong>「参加したイベント」</strong>を押すと該当ユーザ参加したのイベントを表示する。
					</p>
				</div>
				<div class="resume-date text-md-right">
					<span class="text-primary">JUNE 2019 - MIE</span>
				</div>
			</div>
			<p>
				<a href="joinEventList" class="btn btn-info">参加したイベント</a> <a
					href="addEvent" class="btn btn-success">イベントの登録</a>
			</p>
			<div class="row">
				<div class="col-md-12">
					<div class="card-deck">
						<c:forEach items="${createdList.pageList}" var="created">
							<div class="card border-success mb-3 text-center"
								style="width: 18rem;">
								<div class="card-header">
									<i class="fab fa-ethereum"></i>
									<c:out value="${created.title}" />
								</div>
								<div class="card-body text-default">
									<p class="card-text">
										<i class="far fa-bell"></i> 開始日時
									</p>
									<p class="card-text">
										<fmt:formatDate value="${created.startdate }"
											pattern="yyyy年MM月dd日(E)" />
									</p>
									<p class="card-text">
										<fmt:formatDate value="${created.startdate }" pattern="HH時mm分" />
									</p>
									<p class="card-text text-truncate">
										<i class="fas fa-map-marked-alt"></i> 場所:
										<c:out value="${created.place}" />
									</p>
									<a href="detailsEvent/<c:out value="${created.eventId}" />"
										class="btn btn-success">詳細</a>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="pull-right mb-4">
						<tg:pagenation pagedListHolder="${pagedListHolder}"
							pagedLink="${pagedLink}"></tg:pagenation>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="<spring:url value="/js/jquery-2.2.4.min.js" />"></script>
	<script src="<spring:url value="/js/bootstrap.min.js" />"></script>
	<script src="<spring:url value="/js/all.js" />"></script>
</body>
</html>