<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
session.setAttribute("oldEvent" , "false");
session.setAttribute("now" , new java.util.Date());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="<spring:url value="/css/bootstrap.min.css" />"
	rel="stylesheet" />
<link href="<spring:url value="/css/bootstrap-table.min.css" />"
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
			<div class="resume-item d-flex flex-column flex-md-row mb-1">
				<div class="resume-content mr-auto">
					<div class="subheading mb-3">
						<i class="far fa-calendar-alt"></i> イベント一覧
					</div>
					<p>このページは全部のイベント情報をリストで表示する。</p>
					<p><strong>「開催予定のイベント」</strong>を押すと将来のイベントを表示する。<strong>「終了したイベント」</strong>を押すと終了のイベントを表示する。</p>
					<p>
						右の<strong>「検索入力欄」</strong>の中に検索内容を入力して、結果が表示される。
					</p>
				</div>
				<div class="resume-date text-md-right">
					<span class="text-primary"><i style="color: #957bbe;" class = "fab fa-ethereum slow-spin"></i>　JUNE 2019 - MIE</span>
				</div>
			</div>
			<div id="toolbar">
				<button id="allEvent" type="submit" class="btn btn-primary">全部のイベント</button>
				<button id="reserveEvent" type="submit" class="btn btn-info">開催予定のイベント</button>
				<button id="oldEvent" type="submit" class="btn btn-light">終了したイベント</button>
			</div>
			<table id="table" class="table table-striped"></table>
			<div class=" mb-3"></div>
		</div>
	</div>
	<script src="<spring:url value="/js/jquery-2.2.4.min.js" />"></script>
	<script src="<spring:url value="/js/bootstrap.min.js" />"></script>
	<script src="<spring:url value="/js/bootstrap-table.min.js" />"></script>
	<script src="<spring:url value="/js/all.js" />"></script>
	<c:import url="header/paginationOfBootstrap.jsp" />
</body>
</html>