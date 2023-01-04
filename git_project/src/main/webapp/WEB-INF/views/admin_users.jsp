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
                    <hr/>
                    <div class="col-md-12"><h3><fmt:message key="message.manageadmin" bundle="${ressourcesBundle}"/> <fmt:message key="message.listusers" bundle="${ressourcesBundle}"/></h3></div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table id="personList"  class="table table-striped table-md">
                                <thead>
                                    <tr>
                                        <th scope="col" class="table-md-3"><fmt:message key="message.firstname" bundle="${ressourcesBundle}"/></th>
                                        <th scope="col" class="table-md-3"><fmt:message key="message.lastname" bundle="${ressourcesBundle}"/></th>
                                        <th scope="col" class="table-md-5"><fmt:message key="message.email" bundle="${ressourcesBundle}"/></th>
                                        <th scope="col" class="table-md-1"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${usersList}" varStatus="count">
                                    <tr id="person{item.personId}">
                                        <td class="text-left">${item.personFirstname}</td>
                                        <td class="text-left">${item.personLastname}</td>
                                        <td class="text-left">${item.personEmail}</td>
                                        <td class="text-center"><button onClick="editPerson(${item.personId})"><img src="img/edit.png" alt="edit" class="localButton" /></button></td>
                                     </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                <tr id="lineAddPerson" class="table-primary">
                                    <td class="text-left" colspan="3"><input type="text" name="personFirstname" id="personFirstname" class="form-control, input-md-10" placeholder="first name" value="" size="50" /></td>
                                    <td class="text-center" rowspan="3"><button onClick="addPerson()"><img src="img/plus.png" alt="add" class="localButton" /></button></td>
                                </tr>
                                <tr class="table-primary">
                                    <td class="text-left" colspan="3"><input type="text" name="personLastname" id="personLastname" class="form-control, input-md-10" placeholder="last name" value="" size="50"/></td>
                                </tr>
                                <tr class="table-primary">
                                    <td class="text-left" colspan="3"><input type="text" name="personEmail" id="personEmail" class="form-control, input-md-10" placeholder="email" value="" size="50"/></td>
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