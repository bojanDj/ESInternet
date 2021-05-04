<%-- 
    Document   : layout
    Created on : Apr 26, 2021, 10:29:04 PM
    Author     : Bojan
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>
            <tiles:getAsString name="title"></tiles:getAsString>
            </title>
         <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
       
    </head>
    <body>
        <header id ="header">
            <tiles:insertAttribute name="header"/>
        </header>

        <section id="site-content">
            <tiles:insertAttribute name="body"/>
        </section>

        <footer id ="footer">
            <tiles:insertAttribute name="footer"/>
        </footer>
      
    </body>
</html>
