<%@ page pageEncoding="UTF-8"%>
<%@ page import="com.event.myapp.domain.Type"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-start">
		<c:choose>
			<%-- <<ボタン --%>
			<c:when test="${1 == page}">
				<li class="page-item disabled"><a class="page-link" href="">Previous</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link"
					href="?p=<c:out value="${page-1}"/>">Previous</a></li>
			</c:otherwise>
		</c:choose>

		<c:forEach var="Pages" begin="1" end="${numPages}">

			<c:choose>
				<%-- ページボタン --%>
				<c:when test="${Pages == page}">
					<li class="active"><a class="page-link" href="?p=${Pages}">${Pages}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="?p=${Pages}">${Pages}</a></li>
				</c:otherwise>
			</c:choose>

		</c:forEach>

		<c:choose>
			<%-- >>ボタン --%>
			<c:when test="${numPages == page}">
				<li class="page-item disabled"><a class="page-link"
					class="page-link" href="">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link"
					href="?p=<c:out value="${page+1}"/>">Next</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>