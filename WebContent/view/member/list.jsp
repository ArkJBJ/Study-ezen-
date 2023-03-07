<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="servletStudy.vo.*" %>
<%
request.setCharacterEncoding("UTF-8");
List<MemberVO> memberList = (List<MemberVO>)request.getAttribute("memberList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 목록</h2>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>연락처</th>
			<th>주소</th>
			<th>가입일</th>
			<th>등급</th>
			<th>탈퇴여부</th>			
		</tr>
		<%for(MemberVO i : memberList) {%>
		<tr>
			<td><%=i.getMnum() %></td>
			<td><%=i.getMid() %></td>
			<td><%=i.getMname() %></td>
			<td><%=i.getMphone() %></td>
			<td><%=i.getMaddr() %></td>
			<td><%=i.getMenter() %></td>
			<td><%=i.getMgrade() %></td>
			<td><%=i.getMdelyn() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>