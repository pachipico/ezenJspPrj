<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp" />

<jsp:include page="nav.jsp" />
<h2>JavaServer Pages Technology</h2>
<div class="mt-4 p-5 bg-secondary text-white rounded">
	<c:choose>
		<c:when test="${!empty mvo }">
			<h1>Welcome, ${mvo.nickName } (${mvo.email})</h1>
			<h3>Grade : ${mvo.grade }, Last Login: ${mvo.lastLogin }</h3>
		</c:when>
		<c:otherwise>
			<h1>Welcome, JSP</h1>
		</c:otherwise>
	</c:choose>
	<p>The focus of Java EE 5 has been ease of development by making
		use of Java language annotations that were introduced by J2SE 5.0. JSP
		2.1 supports this goal by defining annotations for dependency
		injection on JSP tag handlers and context listeners.</p>
</div>
<script type="text/javascript">
	let msg_reg = '<c:out value="${msg_reg}" />'
	let msg_login = '<c:out value="${msg_login}" />'
	let msg_out = '<c:out value="${msg_out}" />'
	let msg_resign = '<c:out value="${msg_resign}" />'
	if (msg_reg.length > 0) {
		alert(parseInt(msg_reg) > 0 ? "회원가입 성공" : "회원가입 실패");
	} else if (msg_login.length > 0) {
		alert("로그인 실패")
	} else if (msg_out > 0) {
		alert('로그아웃 되었습니다');
	} else if (msg_resign > 0) {
		alert('탈퇴 되었습니다')
	}
</script>
<jsp:include page="footer.jsp" />
