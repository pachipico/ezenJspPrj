<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../header.jsp" />
<jsp:include page="../nav.jsp" />

<table class="table table-hover">
	<thead>
		<tr>
			<th>PNO</th>
			<th>Product Name</th>
			<th>Price</th>
			<th>Writer</th>
			<th>Modified At</th>
			<th>Hit</th>
			<th>Image</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list }" var="pvo">
			<tr>
				<td>${pvo.pno }</td>
				<td><a href="/prodCtrl/detail?pno=${pvo.pno }">${pvo.pname }</a></td>
				<td>${pvo.price }</td>
				<td>${pvo.writer }</td>
				<td>${pvo.modAt }</td>
				<td>${pvo.readCount }</td>
				<td><c:if test="${!empty pvo.imgFile  }">
						<img src="../_fileUpload/th_${pvo.imgFile }">
					</c:if></td>
				<td><c:if test="${mvo.email == pvo.writer || mvo.grade >= 100}">
						<a href="/prodCtrl/modify?pno=${pvo.pno }"
							class="btn btn-sm btn-outline-warning">modify</a>

					</c:if></td>
			</tr>


		</c:forEach>

	</tbody>
</table>
<c:if test="${!empty mvo }">
	<a href="/prodCtrl/register" class="btn btn-primary">Add Product</a>
</c:if>

<jsp:include page="../footer.jsp" />
