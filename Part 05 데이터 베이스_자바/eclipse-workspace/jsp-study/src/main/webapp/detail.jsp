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
	
		String memberType = request.getParameter("memberType");
		String userId = request.getParameter("userId");
	
		MemberService memberService = new MemberService();
		Member member = memberService.detail(memberType, userId); 
	%>


	<h1>ȸ�� ��</h1>

	<table>
		<colgroup>
			<col style="width: 20%;" />
			<col style="width: 80%;" />
		</colgroup>
		<tbody>
			<tr>
				<th>ȸ������</th>
					<td>
					<%= member.getMemberType() %>
					</td>
			</tr>
			<tr>
				<th>���̵�</th>
					<td>
					<%= member.getUserId() %>
					</td>
			</tr>
			<tr>
				<th>��й�ȣ</th>
					<td>
					<%= member.getPassword() %>
					</td>
			</tr>
			<tr>
				<th>�̸�</th>
					<td>
					<%= member.getName() %>
					</td>
			</tr>
			<tr>
				<th>��ȭ��ȣ</th>
					<td>
					<%= member.getMobileNo() %>
					</td>
			</tr>
			<tr>
				<th>������ ���ſ���</th>
					<td>
					<%= member.isMarketingYn() %>
					</td>
			</tr>
			<tr>
				<th>������</th>
					<td>
					<%= member.getRegisterDate() %>
					</td>
			</tr>
		</tbody>
	</table>
	
	<div>
		<a href="list.jsp"> ������� �̵�</a>
	</div>


</body>
</html>