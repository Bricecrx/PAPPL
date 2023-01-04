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
        <script src="js/groupfunctions.js"></script>
        <title>Neptune APP</title>
    </head>

    <body>
        <%@ include file="header.jspf" %>
        <div class="py-5">
            <div class="container">
                <div class="row">
                    <hr/>
                    <div class="col-md-12"><h3><fmt:message key="message.manageadmin" bundle="${ressourcesBundle}"/> <fmt:message key="message.groups" bundle="${ressourcesBundle}"/></h3></div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table id="groupsList"  class="table table-striped table-md">
                                <thead>
                                    <tr>
                                        <th scope="col" class="table-md-2"><fmt:message key="message.groupnumber" bundle="${ressourcesBundle}"/></th>
                                        <th scope="col" class="table-md-9"><fmt:message key="message.lastname" bundle="${ressourcesBundle}"/></th>
                                        <th scope="col" class="table-md-1"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${groupsList}" varStatus="count">
                                                <tr id="group${item.studentgroupId}">
                                                    <td class="text-left">${item.studentgroupId}</td>
                                                    <td class="text-left">${item.studentgroupName}</td>
                                                    <td class="text-center"><button onClick="editGroup(${item.studentgroupId})"><img src="img/edit.png" alt="edit" class="localButton" /></button></td>
                                                </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                    <!--TODO: Ajouter une personne et un étudiant associé dans la base de données-->
                                    <tr id="lineAddGroup" class="table-primary">
                                        <td class="text-left"><input type="text" name="personFirstname" id="groupName" class="form-control, input-md-10" placeholder="nom" value="" size="15" /></td>
                                        <td class="text-center"><button onClick="addGroup()"><img src="img/plus.png" alt="add" class="localButton" /></button></td>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <%@ include file="footer.jspf" %>
        <script src="js/popper.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>

</html>