<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../header.jsp" />
<jsp:include page="../nav.jsp" />
<form action="/memCtrl/modify" method="post" id="modForm">
	<input type="hidden" name="email" value="${mvo.email}">
	<ul class="list-group list-group-flush">
		<li class="list-group-item">Email : ${mvo.email }</li>
		<li class="list-group-item">PassWord : <input type="text"
			value="${mvo.pwd }" name="pwd" /></li>
		<li class="list-group-item">Nick Name : <input type="text"
			value="${mvo.nickName }" name="nickName" /></li>
		<li class="list-group-item">Register At : ${mvo.regAt }</li>
		<li class="list-group-item">Last Login : ${mvo.lastLogin }</li>
		<li class="list-group-item">Grade : ${mvo.grade > 50 ? 'vip' : mvo.grade > 30 ? 'gold' : mvo.grade > 20 ? 'silver' : mvo.grade >= 10 ? 'bronze' : '' }</li>

	</ul>
	<button type="submit" class="btn btn-sm btn-outline-warning px-10">Alternate
		Info</button>
	<button type="submit" class="btn btn-sm btn-outline-danger px-10"
		id="resignBtn">Resign</button>
</form>
<!-- <script type="text/javascript">
const resignBtn = document.getElementById("resignBtn");
const modForm = document.getElementById("modForm");

resignBtn.addEventListener("click", (e) => {
  e.preventDefault();
  console.log("dsaf");
  modForm.setAttribute("action", "/memCtrl/remove");
  modForm.submit();
});

</script> -->
<script src="../resources/js/member.detail.js"></script>

<jsp:include page="../footer.jsp" />
