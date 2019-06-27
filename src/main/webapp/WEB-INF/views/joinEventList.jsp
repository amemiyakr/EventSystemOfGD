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
			<h3 class="mb-5" style="color: #957bbe;">
				<i class="fab fa-buromobelexperte"></i> EVENT SYSTEM
			</h3>
			<c:set value="${pagedListHolder}" var="joinList" />
			<c:url value="/joinEventList" var="pagedLink">
				<c:param name="p" value="~" />
			</c:url>
			<div class="resume-item d-flex flex-column flex-md-row mb-5">
				<div class="resume-content mr-auto">
					<div class="subheading mb-3">
						<i class="far fa-calendar-check"></i> 参加したイベント <span
							class="badge badge-danger">参加</span>
					</div>
					<p>このページは該当ユーザ参加したイベントを表示する。</p>

				</div>
				<div class="resume-date text-md-right">
					<span class="text-primary"><i style="color: #957bbe;"
						class="fab fa-ethereum slow-spin"></i> JUNE 2019 - MIE</span>
				</div>

			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="card-deck">
						<c:forEach items="${joinList.pageList}" var="join">
							<div class="card border-danger mb-3 text-center"
								style="max-width: 18rem;">
								<div class="card-header">
									<i class="fab fa-ethereum"></i>
									<c:out value="${join.event.title}" />
								</div>

								<div class="mt-2 mr-1 ml-1" style="height: 80px;">
									<img style="height: 100%; max-width: 100%;"
										src="${pageContext.request.contextPath}/uploads/imgOfEvent/<c:out value="${join.event.img}" />">
								</div>

								<div class="card-body">
									<p class="card-text">
										<i class="far fa-bell"></i> 開始日時
									</p>
									<p class="card-text">
										<fmt:formatDate value="${join.event.startdate }"
											pattern="yyyy年MM月dd日(E)" />
									</p>
									<p class="card-text">
										<fmt:formatDate value="${join.event.startdate }"
											pattern="HH時mm分" />
									</p>
									<p class="card-text text-truncate">
										<i class="fas fa-map-marked-alt"></i> 場所:
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