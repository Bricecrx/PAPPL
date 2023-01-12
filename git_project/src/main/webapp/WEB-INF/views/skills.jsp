<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

        <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/thomas.css">
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script src="js/main.js"></script>
        <script src="js/functions.js"></script>
        <script src="js/functions_observer.js"></script>
        <title>Neptune APP</title>
    </head>

    <body>
        <%@ include file="header.jspf" %>
        <div class="py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class=""><fmt:message key="menu.Skills" bundle="${ressourcesBundle}"/></h2> 
                        <h3>${person.personFirstname} ${person.personLastname}</h3>
                    </div>
                </div>
            </div>
        </div>
          <table id="parameters"  class="table table-striped table-sm">
            <thead class="text-center">
                <tr>
                    <th colspan="3"><fmt:message key="menu.Skills" bundle="${ressourcesBundle}"/></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="text-center"> <fmt:message key="menu.Skills" bundle="${ressourcesBundle}"/> </td>
                    <td class="text-center"> <fmt:message key="message.component" bundle="${ressourcesBundle}"/> </td>
                    <td class="text-center"> <fmt:message key="message.level" bundle="${ressourcesBundle}"/> </td>
                </tr>
                <tr>
                    <c:forEach var="aSkill" items="${skill}">
                        <td rowspan="4">${aSkill.skillName}</td>
                </tr>
                    <tr>
                        <c:forEach var="aComponent" items="${component}">
                            <c:if test="${aComponent.skillId.skillId == aSkill.skillId}">
                                <tr>
                                    <td>${aComponent.componentName}</td>
                                    <c:set var="thisLevel" value="Débutant" scope="page" />
                                    <c:set var="levelId" value="1" scope="page" />
                                    <c:forEach var="aLevel" items="${level}">
                                        <c:if test="${aLevel.component.componentId == aComponent.componentId}">
                                            <c:set var="thisLevel" value="${aLevel.levelId.levelName}" scope="page" />
                                            <c:set var="levelId" value="${aLevel.levelId}" scope="page" />
                                        </c:if>
                                    </c:forEach>
                                    <td>${thisLevel}</td>
                                    <td>
                                        <button onClick="editSkill(${aComponent.componentId},${person.personId})"><img src="img/edit.png" alt="Edit" class="localButton" /></button>
                                        <%--<form action="#" method="POST">
                                            <input type="hidden" name="personid" value="2"/>
                                            <input type="hidden" name="componentid" value="${aComponent.componentId}"/>
                                            <input type="hidden" name="levelid" value="${levelId}"/>
                                            <button name="add" formaction="addSkill.do"><img src="img/plus.png" alt="Add" class="localButton" /></button>
                                        </form>  --%>
                                    </td>
                                </tr>
                                
                            </c:if>
                        </c:forEach>
                    </tr>
                    
                    </c:forEach>

        </table>
<%@ include file="footer.jspf" %>
<script src="js/popper.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>