<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--한글깨짐을막기위해 ㅠㅠ 더 좋은 방법 없을까요..--%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>회원가입 화면</title>
</head>
<body>
<div id="header">
    <header></header>
</div>

<div id="content">
    <section>
        <form action="/joinProc" method="post">
            <fieldset>
                <legend class="hidden">회원가입 폼</legend>
                <ul id="joinBox">
                    <li>
                        <label for=>이름</label>
                        <input type="text" placeholder="사용자이름" name="uName" value=""/>
                    </li>
                    <li>
                        <label for=>아이디</label>
                        <input type="text" placeholder="아이디" name="uId" value=""/>
                    </li>
                    <li>
                        <label for=>비밀번호</label>
                        <input type="password" placeholder="비밀번호" name="pwd" value=""/>
                    </li>
                </ul>
                    <input type="submit" id="btnJoin" value="회원가입"/>
                </fieldset>
        </form>
    </section>
</div>

<div id="footer">
    <footer></footer>
</div>
</body>
</html>
