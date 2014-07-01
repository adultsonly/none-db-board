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
            <caption>글목록</caption>
            <thead>
            <tr>
                <th>글아이디</th>
                <th>제목</th>
                <th>작성자</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="n" items="${notes}">
                <tr>
                    <td>${n.id}</td>
                    <td><a href="/noteDetail?nId=${n.id}&bId=${bId}">${n.title}</a></td>
                    <td>[<span style="color: red">${n.writer }</span>]</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div>
            <form action="/sort" method="post">
                <select name="howSort" id="">
                    <option value="desc">내림차순</option>
                    <option value="asc">오름차순</option>
                </select>
                <input type="hidden" name="bId" value="${bId}"/>
                <input type="submit" value="정렬"/>
            </form>
        </div>
        <p>
            <a id="noteRegBtn" href="/noteReg?bId=${bId}">글쓰기</a>
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
        $('#noteRegBtn').click(function(){
            alert('클릭!');
            $('table').load('/note/noteReg');
        });
    });*/
</script>
</body>
</html>
