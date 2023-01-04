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
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script src="js/main.js"></script>
        <script src="js/functions.js"></script>
        <script src="js/functions_admin.js"></script>
        <title>Neptune APP</title>
    </head>

    <body>
        <%@ include file="header.jspf" %>
        <div class="py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12"><h3><fmt:message key="message.manageadmin" bundle="${ressourcesBundle}"/> <fmt:message key="message.programme" bundle="${ressourcesBundle}"/></h3></div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table id="programList" class="table table-striped table-md">
                                <thead
                                    <tr>
                                        <th scope="col" class="table-md-3"><fmt:message key="message.anneeuniversitaire" bundle="${ressourcesBundle}"/></th>
                                        <th scope="col" class="table-md-6"><fmt:message key="message.diplome" bundle="${ressourcesBundle}"/></th>
                                        <th scope="col" class="table-md-3"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${programList}" varStatus="count">
                                    <tr id="program${ item.programId }">
                                        <td class="text-left">${item.academicyearId.academicyearTitle}</td>
                                        <td class="text-left">${item.diplomId.diplomName}</td>
                                        <td class="text-center"><c:if test="${empty item.studentgroupCollection}"><button onClick="removeProgram(${item.programId})"><img src="img/delete.png" alt="remove" class="localButton" /></button></c:if></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                <tr id="lineAddProgram" class="table-primary">
                                    <td class="text-left">
                                        <select name="progannmeId" id="proganneeId">
                                            <option value="-1">-</option>
                                            <c:forEach var="item" items="${anneesList}" varStatus="count">
                                                <option value="${item.academicyearId}">${item.academicyearTitle}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td class="text-left">
                                        <select name="progdiplomeId" id="progdiplomeId">
                                            <option value="-1">-</option>
                                            <c:forEach var="item" items="${diplomeList}" varStatus="count">
                                                <option value="${item.diplomId}">${item.diplomName}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td class="text-center"><button onClick="addProgram()"><img src="img/plus.png" alt="add" class="localButton" /></button></td>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/popper.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>

</html>