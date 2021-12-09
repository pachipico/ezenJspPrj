<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../header.jsp" />
<jsp:include page="../nav.jsp" />

<table class="table table-hover">
	<thead>
		<tr>
			<th>Email</th>
			<th>NickName</th>
			<th>Register At</th>
			<th>Last Login</th>
			<th>Grade</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="mvo">

			<tr>
				<td>${mvo.email }</td>
				<td>${mvo.nickName }</td>
				<td>${mvo.regAt}</td>
				<td>${mvo.lastLogin }</td>
				<td><input type="number" value="${mvo.grade }" data-email="${mvo.email}" />
				<button type="button" class="btn btn-sm btn-outline-danger py-0">modify</button></td>
			</tr>


		</c:forEach>
	</tbody>
</table>

<jsp:include page="../footer.jsp" />
