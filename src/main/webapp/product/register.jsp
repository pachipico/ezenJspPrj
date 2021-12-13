<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../header.jsp" />
<jsp:include page="../nav.jsp" />

<form action="/prodCtrl/insert" method="post" id="modForm" enctype="multipart/form-data">
	<input type="hidden" name="writer" value="${mvo.email }">
	<ul class="list-group list-group-flush">
		<li class="list-group-item">Name : <input class="form-controll"
			type="text" name="pname" value="${pvo.pname }">
		</li>
		<li class="list-group-item">price : <input class="form-controll"
			type="number" name="price" value="${pvo.price }">
		</li>
		<li class="list-group-item">Made By : <input
			class="form-controll" type="text" name="madeBy"
			value="${pvo.madeBy }">
		</li>
		<li class="list-group-item">Category : <input
			class="form-controll" type="text" name="category"
			value="${pvo.category }">
		</li>
		<li class="list-group-item">Description : <input
			class="form-controll" type="text" name="description"
			value="${pvo.description }">
		</li>
		<li class="list-group-item">Image File : <input
			class="form-controll" type="file" name="imgFile"
			value="${pvo.imgFile } accept="image/png, image/jpeg, image/jpg, image/gif">
		</li>
	</ul>
	<button type="submit" class="btn btn-sm btn-outline-warning px-10">
		Add</button>

</form>

<jsp:include page="../footer.jsp" />
