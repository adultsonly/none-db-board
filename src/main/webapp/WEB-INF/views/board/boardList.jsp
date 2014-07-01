<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--한글깨짐을막기위해 ㅠㅠ 더 좋은 방법 없을까요..--%>
<%--jstl을 쓰기위해.... 페이지 하드코딩 말고 다른 설정 방법이 있을것 같다.--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>메인 페이지</title>
</head>
<body>
<div id="header">
    <header></header>
</div>

<div id="content">
    <section>
        <table solid border="1px">
            <caption>게시판목록</caption>
            <thead>
                <tr>
                    <th>게시판아이디</th>
                    <th>이름</th>
                    <th>등록자</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="b" items="${boards}">
                <tr>
                    <td>${b.id}</td>
                    <td><a href="/noteList?bId=${b.id}">${b.name}</a></td>
                    <td>${b.regId}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <p>
            <a id="boardAddBtn" href="/boardReg">게시판 추가</a>
        </p>
    </section>
</div>

<div id="footer">
    <footer></footer>
</div>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
    /*$(document).ready(function(){
        alert('hello');
        $('#boardAddBtn').click(function(){
            alert('클릭!');
            $('table > tbody > tr').load('/');
        });
    });*/
</script>
</body>
</html>


