<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="fr.centrale.nantes.neptune.controllers.tools.ToolsManager" %>
<fmt:setBundle basename="fr.centrale.nantes.neptune.ressources.messages" var="ressourcesBundle" />
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
        <title>Neptune APP</title>
    </head>

    <body>
        <%@ include file="header.jspf" %>
        <div class="py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class=""><fmt:message key="message.listusers" bundle="${ressourcesBundle}"/></h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                    <tr>
                                        <th scope="col" class="text-center"><fmt:message key="message.firstname" bundle="${ressourcesBundle}"/></th>
                                        <th scope="col" class="text-center"><fmt:message key="message.lastname" bundle="${ressourcesBundle}"/></th>
                                        <th scope="col"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:if test="${! empty user}">
                                    <c:forEach var="person" items="${listPersonnes}"><tr>
                                        <td scope="col">${person.personLastname}</td>
                                        <td>${person.personFirstname}</td>
                                        <td class="text-center">
                                            <form method="POST">
                                                <input type="hidden" name="connexion" id="connexion" value="${user.connectCode}" />
                                                <input type="hidden" name="user" value="${person.personId}" />
                                                <button name="infos" class="btn" formaction="infosUser.do"><img src="img/show.png" alt="edit" class="icon" /></button>
                                                <button name="edit" class="btn" formaction="editUser.do"><img src="img/edit.png" alt="edit" class="icon" /></button>
                                                <button name="delete" class="btn" formaction="deleteUser.do"><img src="img/delete.png" alt="delete" class="icon" /></button>
                                            </form>
                                        </td>
                                    </tr></c:forEach>
                                    </c:if>
                                </tbody>
                                
                                <c:if test="${ToolsManager.userHasRole(user, 1)}">
                                <tfoot>
                                    <tr id="addNew">
                                        <td scope="col" colspan="2"></td>
                                        <td class="text-center">
                                            <form method="POST">
                                                <input type="hidden" name="connexion" id="connexion" value="${user.connectCode}" />
                                                <input type="hidden" name="user" value="${person.personneId}" />
                                                <button class="btn" formaction="addUser.do"><img src="img/plus.png" alt="add" class="icon" /></button>
                                            </form>
                                        </td>
                                    </tr>
                                    <tr id="import">
                                        <td scope="col" colspan="2">
                                            <label for="importFile">Choose a file to import:</label>
                                            <input type="file" name="importFile" id="importFile" accept=""text/csv/>
                                        </td>
                                        <td class="text-center">
                                            <form method="POST">
                                                <input type="hidden" name="connexion" id="connexion" value="${user.connectCode}" />
                                                <input type="hidden" name="user" value="${person.personneId}" />
                                                <button class="btn" formaction="uploadUsers.do"><img src="img/plus.png" alt="add" class="icon" /></button>
                                            </form>
                                        </td>
                                    </tr>
                                </tfoot>
                                </c:if>
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