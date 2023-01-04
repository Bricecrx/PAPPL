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
        <script src="js/customfunctions.js"></script>
        <script src="js/functions_admin.js"></script>
        <title>Neptune APP</title>
    </head>

    <body>
        <%@ include file="header.jspf" %>
        <div class="py-5">
            <div class="container">
                <div class="row">
                    <hr/>
                    <div class="col-md-12"><h3><fmt:message key="message.manageadmin" bundle="${ressourcesBundle}"/> <fmt:message key="message.students" bundle="${ressourcesBundle}"/></h3></div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table id="studentList"  class="table table-striped table-md">
                                <thead>
                                    <tr>
                                        <th scope="col" class="table-md-2"><fmt:message key="message.firstname" bundle="${ressourcesBundle}"/></th>
                                        <th scope="col" class="table-md-9"><fmt:message key="message.lastname" bundle="${ressourcesBundle}"/></th>
                                        <th scope="col" class="table-md-9"><fmt:message key="message.email" bundle="${ressourcesBundle}"/></th>
                                        <th scope="col" class="table-md-9"><fmt:message key="message.studentnumber" bundle="${ressourcesBundle}"/></th>
                                        <th scope="col" class="table-md-1"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="item" items="${studentsList}" varStatus="count">
                                        <c:forEach var="person" items="${usersList}">
                                            <c:if test = "${item.personId.personId == person.personId}">
                                                <tr id="etudiant${item.studentId}">
                                                    <td class="text-left">${person.personFirstname}</td>
                                                    <td class="text-left">${person.personLastname}</td>
                                                    <td class="text-left">${person.personEmail}</td>
                                                    <td class="text-left">${item.studentIdnumber}</td>
                                                    <td class="text-center"><button onClick="editPerson(${person.personId})"><img src="img/edit.png" alt="edit" class="localButton" /></button></td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                    <!--TODO: Ajouter une personne et un étudiant associé dans la base de données-->
                                    <tr id="lineAddStudent" class="table-primary">
                                        <td class="text-left"><input type="text" name="personFirstname" id="personFirstname" class="form-control, input-md-10" placeholder="prenom" value="" size="5" /></td>
                                        <td class="text-left"><input type="text" name="personLastname" id="personLastname" class="form-control, input-md-10" placeholder="nom" value="" size="12"/></td>
                                        <td class="text-left"><input type="text" name="personEmail" id="personEmail" class="form-control, input-md-10" placeholder="email" value="" size="15"/></td>
                                        <input type="hidden" name="personNumber" value="${person.personId}" />
                                        <td class="text-center"><button onClick="addStudent()"><img src="img/plus.png" alt="add" class="localButton" /></button></td>
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