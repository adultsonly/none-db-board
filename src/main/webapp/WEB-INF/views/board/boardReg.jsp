<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--한글깨짐을막기위해 ㅠㅠ 더 좋은 방법 없을까요..--%>
<%--jstl을 쓰기위해.... 페이지 하드코딩 말고 다른 설정 방법이 있을것 같다.--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>게시판 추가 페이지</title>
</head>
<body>
<div id="header">
    <header></header>
</div>

<div id="content">
    <form action="/boardRegProc" method="post">
        <div>
            <dl>
                <dt>제목</dt>
                <dd>
                    <input name="title"/>
                </dd>
            </dl>
        </div>
        <p>
            <input type="submit" value="저장"/>
            <a href="/boardList">취소</a>
        </p>
    </form>
</div>

<div id="footer">
    <footer></footer>
</div>
</body>
</html>
