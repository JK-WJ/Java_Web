<%--
  Created by IntelliJ IDEA.
  User: WJPC
  Date: 2016/10/31
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    Hello World!
    <hr/>

    <form action="${pageContext.request.contextPath}/Servlet" method="Get">
      <input type="text" name="name"/>
      <input type="submit" value="post测试"/>
      <img src="HelloWorld" width="100" height="50"/>
    </form>

  </body>
</html>
