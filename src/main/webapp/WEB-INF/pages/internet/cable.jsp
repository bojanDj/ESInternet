<%-- 
    Document   : home2
    Created on : May 2, 2021, 7:32:10 PM
    Author     : Bojan
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <div class="testbox">
      <form:form action="${pageContext.request.contextPath}/dsl" method="POST" modelAttribute="internet">
        <div class="banner" style="height: 500px;">
        </div>
        <div class="question">
          <p>Imate li mogucnost prikljucivanja na kablovski internet?</p>
          <div class="question-answer">
            <div>
                <form:radiobutton  value="0" id="radio_4" name="time" path="cloud"/>
              <label for="radio_4" class="radio"><span>Ne</span></label>
            </div>
            <div>
              <form:radiobutton  value="1" id="radio_5" name="time" path="cloud"/>
              <label for="radio_5" class="radio"><span>Da</span></label>
            </div>
          </div>
        </div>
              <div class="btn-block">
          <button type="submit" href="/">Dalje</button>
        </div>
      </form:form>
    </div>
