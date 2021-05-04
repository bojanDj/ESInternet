<%-- 
    Document   : home2
    Created on : May 2, 2021, 7:32:10 PM
    Author     : Bojan
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <div class="testbox">
      <form:form action="${pageContext.request.contextPath}/devices4K" method="POST" modelAttribute="internet">
        <div class="banner" style="height: 500px;">
        </div>
        <div class="item">
          <p>Koliko uredjaja je prikljuceno na internet na svakodnevnom nivou?</p>
          <form:input type="text" name="text" path="devices"/>
        </div>
        <div class="btn-block">
          <button type="submit" href="/">Dalje</button>
        </div>
      </form:form>
    </div>
