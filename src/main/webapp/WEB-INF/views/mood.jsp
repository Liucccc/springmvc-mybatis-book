<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Cherry
  Date: 2019/11/3
  Time: 1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="moods">
    <b>说说列表</b>
    <c:forEach items="${moods}" var="mood">
        ------------------------------------
        <br>
        <b>用户：</b><span id="account">${mood.userName}</span><br>
        <b>说说内容：</b><span id="content">${mood.content}</span><br>
        <b>发表时间：</b><span id="publishTime">${mood.publishTime}</span><br>
        <b>点赞数：</b><span id="praiseNum">${mood.praiseNum}</span><br>
        <div style="margin-left: 350px;">
            <a id="praise" href="/mood/${mood.id}/praise?userId=${mood.userId}">赞</a>
            <a id="praise" href="/mood/${mood.id}/praiseForRedis?userId=${mood.userId}">redis赞</a>
        </div>

    </c:forEach>
</div>
</body>
</html>
