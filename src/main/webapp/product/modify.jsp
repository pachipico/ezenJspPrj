<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../header.jsp" />
<jsp:include page="../nav.jsp" />
<form action="/prodCtrl/update" method="post" id="modForm">
		<input type="hidden"
		name="pno"	value="${pvo.pno }">
		<input type="hidden"
			name="readCount" value="${pvo.readCount }">
		
	<ul class="list-group list-group-flush">
		<li class="list-group-item">Name : <input type="text"
			name="pname" value="${pvo.pname }"></li>
		<li class="list-group-item">price : <input type="text"
			name="price" value="${pvo.price }"></li>
		<li class="list-group-item">Made By : <input type="text"
			name="madeBy" value="${pvo.madeBy }"></li>
		<li class="list-group-item">Category : <input type="text"
			name="category" value="${pvo.category }"></li>
		<li class="list-group-item">Description : <input type="text"
			name="description" value="${pvo.description }"></li>
		<li class="list-group-item">Image File : <input type="text"
			 name="imgFile" value="${pvo.imgFile }"></li>
	</ul>
		<button type="submit" class="btn btn-sm btn-outline-warning px-10">
			Modify</button>
		<button type="submit" class="btn btn-sm btn-outline-danger px-10"
			id="deleteBtn">Delete</button>
</form>
<a href="/prodCtrl/list"
	class="btn btn-sm btn-outline-primary">list</a>
<script src="../resources/js/product.modify.js"></script>
<jsp:include page="../footer.jsp" />
