<%@ page pageEncoding="UTF-8"%>
<%@ page import="com.event.myapp.domain.Type"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<header>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top"
		id="sideNav">
		<a class="navbar-brand js-scroll-trigger" href="#page-top"> <span
			class="d-block d-lg-none"><strong>Event Manager</strong></span><span
			class="d-none d-lg-block"> <img
				class="img-fluid img-profile rounded-circle mx-auto mb-2"
				src="${pageContext.request.contextPath}/uploads/<c:out value="${img}" />">
		</span>
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav">
				<li
					<c:choose>
					<c:when test="${action=='todayEvent'}">
						class="nav-item"
					</c:when>
					<c:otherwise>
						 class="nav-item-default"
					</c:otherwise>
				</c:choose>><a
					class="nav-link js-scroll-trigger"
					href="<spring:url value="/todayEvent" />"><i class="fas fa-calendar-day"></i> 開催中のイベント</a></li>
				<li
					<c:choose>
					<c:when test="${action=='eventList'}">
						class="nav-item"
					</c:when>
					<c:otherwise>
						 class="nav-item-default"
					</c:otherwise>
				</c:choose>><a
					class="nav-link js-scroll-trigger"
					href="<spring:url value="/eventList" />"><i class="far fa-calendar-alt"></i> イベント一覧</a></li>
				<li
					<c:choose>
					<c:when test="${action=='MyCreatedEvent'}">
						class="nav-item"
					</c:when>
					<c:otherwise>
						 class="nav-item-default"
					</c:otherwise>
				</c:choose>>
					<a class="nav-link" href="<spring:url value="/myEventList" />"><i class="fas fa-clipboard-list"></i> My
						イベント管理</a>
				</li>
				<li
					<c:choose>
					<c:when test="${action=='userList'}">
						class="nav-item"
					</c:when>
					<c:otherwise>
						 class="nav-item-default"
					</c:otherwise>
				</c:choose>><a class="nav-link js-scroll-trigger"
					href="<spring:url value="/userList" />"><i class="far fa-address-card"></i> ユーザ管理</a></li>
				<li class="nav-link"></li>
				<li class="nav-link"></li>
				<li class="nav-link"><i class="fas fa-user-tie"></i>  <c:out value="${userName}" /></li>
				<li class="nav-link"><i class="fas fa-id-badge"></i> <c:choose>
						<c:when test="${typeId==2}">
							管理ユーザ
						</c:when>
						<c:otherwise>
							一般ユーザ
						</c:otherwise>
					</c:choose></li>
				<li class="nav-item-default"><a class="nav-link js-scroll-trigger"
					href="<spring:url value="/logout" />"><i class="fas fa-sign-out-alt"></i> LOGOUT</a></li>
			</ul>
		</div>
	</nav>
</header>