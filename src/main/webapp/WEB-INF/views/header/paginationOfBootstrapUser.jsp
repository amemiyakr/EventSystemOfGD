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
				field : 'id',	//date tag
				title : 'ID'	//title of you like
			}, {
				field : 'name',
				title : '<i class="fas fa-user"></i>　氏名'
			}, {
				field : 'groupName',
				title : '<i class="fas fa-user-tag"></i>　所属グループ'
			} , {
				field : 'role',
				title : '<i class="fas fa-id-badge"></i>　身分'
			} , {
				field : 'details',
				title : '詳細'
			}  ],
			data : [
				<c:forEach items="${userList}" var="user">
				{
				id : '<c:out value="${user.userId }" />',
				name : '<c:out value="${user.userName }" />',
				groupName : '<c:out value="${user.group.groupName}" />',
				role  : '<c:out value="${user.type.typeName}" />',
				details : '<a href="detailsUser/<c:out value="${user.userId}" />" class="btn btn-default">詳細</a>',
				},
				</c:forEach>
			]
		})
	</script>