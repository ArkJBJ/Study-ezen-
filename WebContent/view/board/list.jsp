<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="servletStudy.vo.BoardVO" %>
<%
request.setCharacterEncoding("UTF-8");
List<BoardVO> boardList = (List<BoardVO>)request.getAttribute("boardList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글목록</h2>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>대분류</th>
			<th>소분류</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<%for(BoardVO i : boardList) {%>
		<tr>
			<td><%=i.getBindex() %></td>
			<td>
			<%=
			i.getBftype().equals("J")?"자바":i.getBftype().equals("S")?"자바스크립트":i.getBftype().equals("P")?"파이썬":
				i.getBftype().equals("C")?"C++/C#":"기타"
			%>
			</td>
			<td><%=i.getBstype().equals("R")?"코드리뷰":"기술정보" %></td>
			<td><%=i.getBtitle() %></td>
			<td><%=i.getBdate() %></td>
			<td><%=i.getBcount() %></td>
		</tr>
		<%} %>
	</table>
</body>
</html>