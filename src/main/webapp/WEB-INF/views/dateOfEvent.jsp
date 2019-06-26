<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ page import="java.util.Date"%>
<c:set var="now">
	<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd "
		type="date" />
</c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<spring:url value="/css/bootstrap.min.css" />"
	rel="stylesheet" />
<link href="<spring:url value="/css/all.min.css" />" rel="stylesheet" />
<link href="<spring:url value="/css/style.css" />" rel="stylesheet" />
<title>最近のイベント</title>
</head>
<body>
	<div class="container">
		<div class="resume-section p-3 p-lg-5 d-flex flex-column">
			<c:import url="header/header.jsp" />
			<h3 class="mb-5" style="color: #957bbe;">
				<i class="fab fa-buromobelexperte"></i> EVENT SYSTEM
			</h3>
			<div class="bg-image-loop">
				<div class="resume-item d-flex flex-column flex-md-row mb-5">
					<div class="resume-content mr-auto">
						<div class="subheading mb-3">
							<i class="far fa-calendar-alt"></i> 最近のイベント
						</div>
						<p>このページは最近一週間のイベント情報を表示する。</p>
					</div>
					<div class="resume-date text-md-right">
						<span class="text-primary">JUNE 2019 - MIE</span>
					</div>
				</div>
			</div>

			<nav>
				<div class="EventIcon nav nav-tabs" id="nav-tab" role="tablist">
					<c:forEach items="${dateOfWeek }" var="day">
						<c:set var="sdfDay">
							<fmt:formatDate value="${day}" pattern="yyyy-MM-dd " type="date" />
						</c:set>
						<a
							class="nav-item nav-link<c:if test="${sdfDay==now }"> active</c:if>"
							id="<c:out value="${sdfDay}" />-tab" data-toggle="tab"
							href="#nav-<c:out value="${sdfDay}" />" role="tab"
							aria-controls="nav-<c:out value="${sdfDay}" />"
							aria-selected="<c:if test="${sdfDay==now }">true</c:if>false">
							<fmt:formatDate value="${day }" pattern="yyyy年MM月dd日(E)" />
						</a>
					</c:forEach>
				</div>
			</nav>
			<div class="tab-content" id="nav-tabContent">
				<c:forEach items="${dateOfWeek }" var="day">
					<c:set var="sdfDay">
						<fmt:formatDate value="${day}" pattern="yyyy-MM-dd " type="date" />
					</c:set>
					<div
						class="tab-pane fade<c:if test="${sdfDay==now }"> show active</c:if>"
						id="nav-<c:out value="${sdfDay}" />" role="tabpanel"
						aria-labelledby="<c:out value="${sdfDay}" />-tab">
						<c:forEach items="${eventList }" var="event">
							<c:if test="${event.startdate < day && event.enddate >= day}">
								<div class="bd-callout bd-callout-OfEvent">
									<h4>
										<i class="fab fa-ethereum"></i> <a
											href="detailsEvent/<c:out value="${event.eventId}" />"><c:out
												value="${event.title}" /></a>
										<c:forEach items="${joinList}" var="join">
											<c:if
												test="${join.event.eventId == event.eventId && join.user.userId == userId }">
												<span class="badge badge-danger align-top"
													style="font-size: 9px;">参加</span>
											</c:if>
										</c:forEach>
									</h4>
									<p>
										<c:out value="${event.details}" />
										<a href="detailsEvent/<c:out value="${event.eventId}" />"
											class="btn btn-default">詳細</a>
									</p>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<script src="<spring:url value="/js/jquery-2.2.4.min.js" />"></script>
	<script src="<spring:url value="/js/bootstrap.min.js" />"></script>
	<script src="<spring:url value="/js/all.js" />"></script>
</body>
</html>