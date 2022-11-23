<%@page import="db.Member"%>
<%@page import="java.util.List"%>
<%@page import="db.MemberService"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
table {
	width: 100%;
}

th, td {
	border: solid 1px #000;
}
</style>


</head>
<body>

	<%
		MemberService memberService = new MemberService();
		List<Member> memberList = memberService.list(); 
	%>


	<h1>회원 목록</h1>

	<table>
		<thead>
			<tr>
				<th>회원구분</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<%
				for (Member member : memberList) {
				%>
					<tr>
						<td> <%=member.getMemberType()%> </td>
						<td> 
						<a href="detail.jsp?memberType=<%=member.getMemberType() %>&userId=<%=member.getUserId()%>">
						<%=member.getUserId()%> 
						</a>
						</td>
						<td> <%=member.getPassword()%> </td>
						<td> <%=member.getName()%> </td>
					</tr>
					
				<%
					}
				%>
			</tr>
		</tbody>
	</table>
	
	<div>
		<a href="add.jsp">회원 추가</a>
	</div>
	


</body>
</html>