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
        <script src="js/studentgroupfunctions.js"></script>
        <title>Neptune APP</title>
    </head>

    <body>
        <%@ include file="header.jspf" %>
        <div class="py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class=""><fmt:message key="message.infogroup" bundle="${ressourcesBundle}"/></h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <form method="POST">
                            <input type="hidden" name="user" id="userEditGroup" value="<c:if test="${! empty user}">${user.personId.personId}</c:if>" />
                            <input type="hidden" name="connexion" id="connexionEditPerson" value="<c:if test="${! empty user}">${user.connectCode}</c:if>" />
                            <input type="hidden" name="id" value="${group.studentgroupId}" />
                            <div class="table-responsive">
                                <table class="table table-striped table-sm ">
                                    <tbody>
                                        <tr>
                                            <th scope="col"><fmt:message key="message.lastname" bundle="${ressourcesBundle}"/></th>
                                            <td><input type="text" class="form-control" name="studentgroupName" value="${group.studentgroupName}" /></td>
                                        </tr>
                                        <tr>
                                            <th scope="col"><fmt:message key="message.year" bundle="${ressourcesBundle}"/></th>
                                            <td><input type="text" class="form-control" name="departAnneeAcademique" value="${group.programId.academicyearId.academicyearTitle}" /></td>
                                        </tr>
                                        <tr>
                                            <th scope="col"><fmt:message key="message.diplome" bundle="${ressourcesBundle}"/></th>
                                            <td><input type="text" class="form-control" name="diplome" value="${group.programId.diplomId.diplomName}" /></td>
                                            <td class="text-center"><button class="btn" formaction="saveGroup.do"><img src="img/save.png" alt="save" class="icon" /></button></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </form>
                    </div>
                </div>                                     
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class=""><fmt:message key="message.students" bundle="${ressourcesBundle}"/></h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table id="studentGroupList"  class="table table-striped table-md">
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
                                    <!-- TODO: faire fonctionner le bouton delete puis créer -->
                                    <c:forEach var="studentregistration" items="${group.studentregistrationCollection}" varStatus="count">
                                        <c:forEach var="person" items="${usersList}">
                                            <c:if test = "${studentregistration.studentId.personId.personId == person.personId}">
                                                <tr id="etudiant${studentregistration.studentId.studentId}">
                                                    <td class="text-left">${person.personFirstname}</td>
                                                    <td class="text-left">${person.personLastname}</td>
                                                    <td class="text-left">${person.personEmail}</td>
                                                    <td class="text-left">${studentregistration.studentId.studentIdnumber}</td>
                                                    <td class="text-center"><button onClick="DeleteStudentGroup(${studentregistration.studentregistrationId}, ${group.studentgroupId})"><img src="img/delete.png" alt="edit" class="localButton" /></button></td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr id="lineAddStudentToGroup" class="table-primary">
                                        <td class="text-left"><input type="text" name="studentIdnumber" id="studentIdnumber" class="form-control, input-md-10" placeholder="Numéro étudiant" value="" size="20" /></td>
                                        <td class="text-center"><button onClick=""><img src="img/plus.png" alt="add" class="localButton" /></button></td>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
                <%@ include file="footer.jspf" %>
                <script src="js/popper.min.js"></script>
                <script src="bootstrap/js/bootstrap.min.js"></script>
                </body>

                </html>