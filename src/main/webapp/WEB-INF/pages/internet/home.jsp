<%-- 
    Document   : home
    Created on : Apr 27, 2021, 5:23:38 PM
    Author     : Bojan
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <div class="testbox">
      <form:form action="${pageContext.request.contextPath}/users" method="POST" modelAttribute="internet">
          <div class="banner" style="height: 500px;">
        </div>
        <div class="item">
          <p>Postovani korisnice, dobrodosli!</p>
          <p>Postavicemo Vam par pitanja kako bismo mogli da Vam na osnovu ekspertskog znanja pomognemo pri odabiru interneta. </p>
        </div>
        <div class="btn-block">
          <button type="submit" href="/">Zapocni...</button>
        </div>
      </form:form>
    </div>
