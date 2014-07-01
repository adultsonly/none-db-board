<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--한글깨짐을막기위해 ㅠㅠ 더 좋은 방법 없을까요..--%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8"/>
    <title>로그인화면</title>
</head>
<body>
<div id="header">
    <header></header>
</div>

<div id="content">
    <section>
        <form action="/loginProc" method="post">
            <fieldset>
                <legend class="hidden">로그인 폼</legend>
                <ul id="loginBox">
                    <li>
                        <label for=>아이디</label>
                        <input type="text" placeholder="아이디" name="uId" value="shiny"/>
                    </li>
                    <li>
                        <label for=>비밀번호</label>
                        <input type="password" placeholder="비밀번호" name="pwd" value="1111"/></li>
                </ul>
                    <input type="submit" id="btnLogin" value="로그인"/>
                </fieldset>
        </form>
    </section>
</div>

<div id="footer">
    <footer></footer>
</div>
</body>
</html>
