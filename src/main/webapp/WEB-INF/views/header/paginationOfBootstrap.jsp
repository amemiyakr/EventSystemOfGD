<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript">
		$('#table').bootstrapTable({
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
			columns : [ {
				field : 'title',	//date tag
				title : 'タイトル'	//title of you like
			}, {
				field : 'startdate',
				title : '開始日時'
			}, {
				field : 'place',
				title : '場所'
			} , {
				field : 'groupName',
				title : '対象グループ'
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
		})
	</script>