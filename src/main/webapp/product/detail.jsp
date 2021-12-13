<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../header.jsp" />
<jsp:include page="../nav.jsp" />

<ul class="list-group list-group-flush">
	<li class="list-group-item">PNO : ${pvo.pno }</li>
	<li class="list-group-item">Name : ${pvo.pname }</li>
	<li class="list-group-item">price : ${pvo.price }</li>
	<li class="list-group-item">Made By : ${pvo.madeBy }</li>
	<li class="list-group-item">Register At : ${pvo.regAt }</li>
	<li class="list-group-item">Writer : ${pvo.writer }</li>
	<li class="list-group-item">Category : ${pvo.category }</li>
	<li class="list-group-item">Description : ${pvo.description }</li>
	<li class="list-group-item">Modified At : ${pvo.modAt }</li>
	<li class="list-group-item">Read Count : ${pvo.readCount }</li>
	<li class="list-group-item">Image File : ${pvo.imgFile }</li>
	<li>
		<img alt="" src="../_fileUpload/${pvo.imgFile }">
	</li>
</ul>

<c:if test="${mvo.email == pvo.writer || mvo.grade >= 100}">
	<a href="/prodCtrl/modify?pno=${pvo.pno }"
		class="btn btn-sm btn-outline-warning">modify</a>
		
	<button class="btn btn-sm btn-danger" id="delBtn" >del</button>
	<form action="/prodCtrl/remove" method="post" id="delForm" style="display: none;">
		<input type="hidden" name="pno" value="${pvo.pno }">
		<input type="hidden" name="imgFile" value="${pvo.imgFile }">
	</form>
	<%-- <a href="/prodCtrl/remove?pno=${pvo.pno }" id="delBtn"
		class="btn btn-sm btn-outline-danger">delete</a> --%>
</c:if>
<a href="/prodCtrl/list"
	class="btn btn-sm btn-outline-primary">list</a>
	<script src="/resources/js/product.detail.js">

</script>
<jsp:include page="../footer.jsp" />
