<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<spring:url value="/css/bootstrap.min.css" />"
	rel="stylesheet" />
<link href="<spring:url value="/css/all.min.css" />" rel="stylesheet" />
<link href="<spring:url value="/css/style.css" />" rel="stylesheet" />
<title>開催中のイベント</title>
</head>
<body>
	<div class="container">
		<div class="resume-section p-3 p-lg-5 d-flex flex-column">
			<c:import url="header/header.jsp" />
			<h3 class="mb-5" style="color: #957bbe;">
				<i class="fab fa-buromobelexperte"></i> EVENT SYSTEM
			</h3>
			<c:set value="${pagedListHolder}" var="todayEventList" />
			<c:url value="/todayEvent" var="pagedLink">
				<c:param name="p" value="~" />
			</c:url>
			<div class="resume-item d-flex flex-column flex-md-row mb-5">
				<div class="resume-content mr-auto">
					<div class="subheading mb-3">
						<i class="fas fa-calendar-day"></i> 開催中のイベント
					</div>
					<p>このページは本日開催中のイベントのみを開始日時の新しい順に並べて表示する。</p>
					<p>
						自分が参加を表明しているイベントのタイトル右側には [ <strong>参加</strong> ] と表示する。
					</p>
					<p>
						<a href="dateOfEvent" class="btn btn-primary">最近のイベント</a>
					</p>
				</div>
				<div class="resume-date text-md-right">
					<span class="text-primary"><i style="color: #957bbe;"
						class="fab fa-ethereum slow-spin"></i> JUNE 2019 - MIE</span>
				</div>
			</div>

			<div class="row">
				<div class="col-md-12">
					<div class="card-deck">
						<c:forEach items="${todayEventList.pageList}" var="event">
							<div
								class="card
									<c:forEach items="${joinList}" var="join">
										<c:if test="${join.event.eventId == event.eventId && join.user.userId == userId }">
											border-danger
										</c:if>
									</c:forEach>
							border-info
							mb-3 text-center"
								style="width: 18rem;">
								<div class="card-header">
									<i class="fab fa-ethereum"></i>
									<c:out value="${event.title}" />
									<c:forEach items="${joinList}" var="join">
										<c:if
											test="${join.event.eventId == event.eventId && join.user.userId == userId }">
											<span class="badge badge-danger">参加</span>
										</c:if>
									</c:forEach>
								</div>

								<div class="mt-2 mr-1 ml-1" style="height: 80px;">
									<img style="height: 100%; max-width: 100%;"
										src="${pageContext.request.contextPath}/uploads/imgOfEvent/<c:out value="${event.img}" />">
								</div>

								<div class="card-body text-default">
									<p class="card-text">
										<i class="far fa-bell"></i> 開始日時
									</p>
									<p class="card-text">
										<fmt:formatDate value="${event.startdate }"
											pattern="yyyy年MM月dd日(E)" />
									</p>
									<p class="card-text">
										<fmt:formatDate value="${event.startdate }" pattern="HH時mm分" />
									</p>
									<p class="card-text text-truncate">
										<i class="fas fa-map-marked-alt"></i> 場所:
										<c:out value="${event.place}" />
									</p>
									<a href="detailsEvent/<c:out value="${event.eventId}" />"
										class="btn btn-info">詳細</a>
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