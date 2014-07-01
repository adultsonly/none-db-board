<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--한글깨짐을막기위해 ㅠㅠ 더 좋은 방법 없을까요..--%>
<%--jstl을 쓰기위해.... 페이지 하드코딩 말고 다른 설정 방법이 있을것 같다.--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>상세 페이지</title>
</head>
<body>
<div id="header">
    <header></header>
</div>

<div id="content">
    <article>
        <div>
            <dl>
                <dt>제목</dt>
                <dd>
                    ${note.title}
                </dd>
            </dl>
            <dl>
                <dt>작성자</dt>
                <dd>${note.writer}</dd>
            </dl>
            <div>
                <p>
                    ${note.content}
                </p>
            </div>
        </div>
    </article>
    <p>
        <a href="/noteList?bId=${bId}">목록</a>
        <a href="/noteEdit?nId=${note.id}&bId=${bId}">수정</a>
        <a href="/noteDelProc?nId=${note.id}&bId=${bId}">삭제</a>
    </p>
</div>

<div id="footer">
    <footer></footer>
</div>
</body>
</html>
