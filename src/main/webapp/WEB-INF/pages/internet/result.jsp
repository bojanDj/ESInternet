<%-- 
    Document   : home
    Created on : Apr 27, 2021, 5:23:38 PM
    Author     : Bojan
--%>

<%-- 
    Document   : home2
    Created on : May 2, 2021, 7:32:10 PM
    Author     : Bojan
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <div class="testbox">
      <form:form action="${pageContext.request.contextPath}/users" method="POST" modelAttribute="internet">
        <div class="banner" style="height: 500px;">
        </div>
        <div class="item">
          <p>Preporucena brzina interneta za Vas je ${internet.speed} mbps.</p>
          <p>Preporuceni tip interneta za Vas je ${internet.type}.</p>
        </div>
        <div class="btn-block">
          <button type="submit" href="/">Pokreni ponovo...</button>
        </div>
      </form:form>
    </div>
 
