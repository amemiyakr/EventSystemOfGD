<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
$("#table").bootstrapTable('destroy');
		$('#table').bootstrapTable({
			toolbar:'#toolbar',
			paginationPreText:'Prev',
			paginationNextText:'Next',
			paginationHAlign:'left',
			paginationDetailHAlign:'right',
			paginationLoop: false,
			pagination : true,		//open the pagination
			sidePagination : 'client', 		//
			pageSize : 5, 		//the pageNumber
			pageList :'Unlimited',	//the pageList
			showRefresh : false,	//show the botton of refresh
			search : true,	//show search
			striped: true,
			columns : [ {
				field : 'title',	//date tag
				title : '<i class="fab fa-ethereum"></i>　タイトル'	//title of you like
			}, {
				field : 'startdate',
				title : '<i class="far fa-bell"></i>　開始日時'
			}, {
				field : 'place',
				title : '<i class="fas fa-map-marked-alt"></i>　場所'
			} , {
				field : 'groupName',
				title : '<i class="fas fa-user-tag"></i>　対象グループ'
			} , {
				field : 'details',
				title : '詳細'
			}  ],
			data : [
				<c:forEach items="${eventList}" var="event">
				{
				title : '<c:out value="${event.title}" /><c:forEach items="${joinList}" var="join"><c:if test="${join.event.eventId == event.eventId && join.user.userId == userId }"> <span class="badge badge-danger">参加</span></c:if></c:forEach>',
				startdate : '<fmt:formatDate value="${event.startdate }" pattern="yyyy年MM月dd日(E) HH時mm分" />',
				place : '<c:out value="${event.place}" />',
				groupName : '<c:choose><c:when test="${event.group.groupName==null}">全員</c:when><c:otherwise><c:out value="${event.group.groupName}" /></c:otherwise></c:choose>',
				details : '<a href="detailsEvent/<c:out value="${event.eventId}" />" class="btn btn-default">詳細</a>',
				},
				</c:forEach>
			]
		});

		$('#oldEvent').click(function () {
			<c:set value="true" var="oldEvent" scope="session"/>
			$("#table").bootstrapTable('destroy');
			$('#table').bootstrapTable('refresh');
			console.log(<c:out value="${oldEvent }" />);
					$('#table').bootstrapTable({
						toolbar:'#toolbar',
						paginationPreText:'Prev',
						paginationNextText:'Next',
						paginationHAlign:'left',
						paginationDetailHAlign:'right',
						paginationLoop: false,
						pagination : true,		//open the pagination
						sidePagination : 'client', 		//
						pageSize : 5, 		//the pageNumber
						pageList :'Unlimited',	//the pageList
						search : true,	//show search
						columns : [ {
							field : 'title',	//date tag
							title : '<i class="fab fa-ethereum"></i>　タイトル'	//title of you like
						}, {
							field : 'startdate',
							title : '<i class="far fa-bell"></i>　開始日時'
						}, {
							field : 'place',
							title : '<i class="fas fa-map-marked-alt"></i>　場所'
						} , {
							field : 'groupName',
							title : '<i class="fas fa-user-tag"></i>　対象グループ'
						} , {
							field : 'details',
							title : '詳細'
						}  ],
						data : [
							<c:forEach items="${eventList}" var="event">
							<c:if test="${event.enddate < now }">
							{
							title : '<c:out value="${event.title}" /><c:forEach items="${joinList}" var="join"><c:if test="${join.event.eventId == event.eventId && join.user.userId == userId }"> <span class="badge badge-danger">参加した</span></c:if></c:forEach>',
							startdate : '<fmt:formatDate value="${event.startdate }" pattern="yyyy年MM月dd日(E) HH時mm分" />　<span class="badge badge-secondary">終了</span>　',
							place : '<c:out value="${event.place}" />',
							groupName : '<c:choose><c:when test="${event.group.groupName==null}">全員</c:when><c:otherwise><c:out value="${event.group.groupName}" /></c:otherwise></c:choose>',
							details : '<a href="detailsEvent/<c:out value="${event.eventId}" />" class="btn btn-default">詳細</a>',
							},
							</c:if>
							</c:forEach>
						]
					});
		})

		$('#reserveEvent').click(function () {
			<c:set value="true" var="oldEvent" scope="session"/>
			$("#table").bootstrapTable('destroy');
			$('#table').bootstrapTable('refresh');
			console.log(<c:out value="${oldEvent }" />);
					$('#table').bootstrapTable({
						toolbar:'#toolbar',
						paginationPreText:'Prev',
						paginationNextText:'Next',
						paginationHAlign:'left',
						paginationDetailHAlign:'right',
						paginationLoop: false,
						pagination : true,		//open the pagination
						sidePagination : 'client', 		//
						pageSize : 5, 		//the pageNumber
						pageList :'Unlimited',	//the pageList
						search : true,	//show search
						columns : [ {
							field : 'title',	//date tag
							title : '<i class="fab fa-ethereum"></i>　タイトル'	//title of you like
						}, {
							field : 'startdate',
							title : '<i class="far fa-bell"></i>　開始日時'
						}, {
							field : 'place',
							title : '<i class="fas fa-map-marked-alt"></i>　場所'
						} , {
							field : 'groupName',
							title : '<i class="fas fa-user-tag"></i>　対象グループ'
						} , {
							field : 'details',
							title : '詳細'
						}  ],
						data : [
							<c:forEach items="${eventList}" var="event">
							<c:if test="${event.startdate > now }">
							{
							title : '<c:out value="${event.title}" /><c:forEach items="${joinList}" var="join"><c:if test="${join.event.eventId == event.eventId && join.user.userId == userId }"> <span class="badge badge-danger">参加</span></c:if></c:forEach>',
							startdate : '<fmt:formatDate value="${event.startdate }" pattern="yyyy年MM月dd日(E) HH時mm分" />',
							place : '<c:out value="${event.place}" />',
							groupName : '<c:choose><c:when test="${event.group.groupName==null}">全員</c:when><c:otherwise><c:out value="${event.group.groupName}" /></c:otherwise></c:choose>',
							details : '<a href="detailsEvent/<c:out value="${event.eventId}" />" class="btn btn-default">詳細</a>',
							},
							</c:if>
							</c:forEach>
						]
					});
		})

		$('#allEvent').click(function () {
			<c:set value="true" var="oldEvent" scope="session"/>
			$("#table").bootstrapTable('destroy');
			$('#table').bootstrapTable('refresh');
			console.log(<c:out value="${oldEvent }" />);
					$('#table').bootstrapTable({
						toolbar:'#toolbar',
						paginationPreText:'Prev',
						paginationNextText:'Next',
						paginationHAlign:'left',
						paginationDetailHAlign:'right',
						paginationLoop: false,
						pagination : true,		//open the pagination
						sidePagination : 'client', 		//
						pageSize : 5, 		//the pageNumber
						pageList :'Unlimited',	//the pageList
						search : true,	//show search
						columns : [ {
							field : 'title',	//date tag
							title : '<i class="fab fa-ethereum"></i>　タイトル'	//title of you like
						}, {
							field : 'startdate',
							title : '<i class="far fa-bell"></i>　開始日時'
						}, {
							field : 'place',
							title : '<i class="fas fa-map-marked-alt"></i>　場所'
						} , {
							field : 'groupName',
							title : '<i class="fas fa-user-tag"></i>　対象グループ'
						} , {
							field : 'details',
							title : '詳細'
						}  ],
						data : [
							<c:forEach items="${eventList}" var="event">
							{
							title : '<c:out value="${event.title}" /><c:forEach items="${joinList}" var="join"><c:if test="${join.event.eventId == event.eventId && join.user.userId == userId }"> <span class="badge badge-danger">参加</span></c:if></c:forEach>',
							startdate : '<fmt:formatDate value="${event.startdate }" pattern="yyyy年MM月dd日(E) HH時mm分" />',
							place : '<c:out value="${event.place}" />',
							groupName : '<c:choose><c:when test="${event.group.groupName==null}">全員</c:when><c:otherwise><c:out value="${event.group.groupName}" /></c:otherwise></c:choose>',
							details : '<a href="detailsEvent/<c:out value="${event.eventId}" />" class="btn btn-default">詳細</a>',
							},
							</c:forEach>
						]
					});
		})
	</script>