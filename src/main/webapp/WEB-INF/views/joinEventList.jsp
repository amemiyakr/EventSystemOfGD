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
<title>イベント一覧</title>
</head>
<body>
	<div class="container">
		<div class="resume-section p-3 p-lg-5 d-flex flex-column">
			<c:import url="header/header.jsp" />
			<h3 style="color: #957bbe;">
				<i class="fab fa-buromobelexperte"></i> EVENT SYSTEM
			</h3>
			<c:set value="${pagedListHolder}" var="joinList" />
			<c:url value="/joinEventList" var="pagedLink">
				<c:param name="p" value="~" />
			</c:url>
			<div class="resume-item d-flex flex-column flex-md-row mb-5">
				<div class="resume-content mr-auto">
					<div class="subheading mb-3">参加したイベント</div>
					<p>このページは該当ユーザ参加したイベントを表示する。</p>

				</div>
				<div class="resume-date text-md-right">
					<span class="text-primary">JUNE 2019 - MIE</span>
				</div>

			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="card-deck">
						<c:forEach items="${joinList.pageList}" var="join">
							<div class="card border-danger mb-3 text-center"
								style="max-width: 18rem;">
								<div class="card-header">
									<c:out value="${join.event.title}" />
								</div>
								<div class="card-body">
									<p class="card-text">開始日時</p>
									<p class="card-text">
										<fmt:formatDate value="${join.event.startdate }"
											pattern="yyyy年MM月dd日(E)" />
									</p>
									<p class="card-text">
										<fmt:formatDate value="${join.event.startdate }"
											pattern="HH時mm分ss" />
									</p>
									<p class="card-text">
										場所:
										<c:out value="${join.event.place}" />
									</p>
									<a href="detailsEvent/<c:out value="${join.event.eventId}" />"
										class="btn btn-default">詳細</a>

								</div>
							</div>
						</c:forEach>
					</div>
					<div class="pull-right">
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