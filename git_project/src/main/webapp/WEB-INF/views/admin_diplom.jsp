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
                    <div class="col-md-12"><h3><fmt:message key="message.manageadmin" bundle="${ressourcesBundle}"/> <fmt:message key="message.diplome" bundle="${ressourcesBundle}"/></h3></div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table id="diplomeList"  class="table table-striped table-md">
                                <thead>
                                    <tr>
                                        <th scope="col" class="table-md-11"><fmt:message key="message.libelle" bundle="${ressourcesBundle}"/></th>
                                        <th scope="col" class="table-md-1"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${diplomeList}" varStatus="count">
                                    <tr id="diplome${item.diplomId}">
                                        <td class="text-left">${item.diplomName}</td>
                                        <td class="text-center"><c:if test="${empty item.programCollection}"><button onClick="removeDiplome(${item.diplomId})"><img src="img/delete.png" alt="remove" class="localButton" /></button></c:if></td>
                                        </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                <tr id="lineAddDiplome" class="table-primary">
                                    <td class="text-left"><input type="text" name="diplomeLib" id="diplomeLib" class="form-control" placeholder="libelle" value="" /></td>
                                    <td class="text-center"><button onClick="addDiplome()"><img src="img/plus.png" alt="add" class="localButton" /></button></td>
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