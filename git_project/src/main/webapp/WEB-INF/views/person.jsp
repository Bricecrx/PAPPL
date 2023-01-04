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
        <title>Neptune APP</title>
    </head>

    <body>
        <%@ include file="header.jspf" %>
        <div class="py-5">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h2 class=""><fmt:message key="message.infouser" bundle="${ressourcesBundle}"/></h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <form method="POST">
                            <input type="hidden" name="user" id="userEditPerson" value="<c:if test="${! empty user}">${user.personId.personId}</c:if>" />
                            <input type="hidden" name="connexion" id="connexionEditPerson" value="<c:if test="${! empty user}">${user.connectCode}</c:if>" />
                            <input type="hidden" name="id" value="${person.personId}" />
                            <div class="table-responsive">
                                <table class="table table-striped table-sm ">
                                    <tbody>
                                        <tr>
                                            <th scope="col"><fmt:message key="message.firstname" bundle="${ressourcesBundle}"/></th>
                                            <td><input type="text" class="form-control" name="Firstname" value="${person.personFirstname}" /></td>
                                        </tr>
                                        <tr>
                                            <th scope="col"><fmt:message key="message.lastname" bundle="${ressourcesBundle}"/></th>
                                            <td><input type="text" class="form-control" name="Lastname" value="${person.personLastname}" /></td>
                                        </tr>
                                        <tr>
                                            <th scope="col"><fmt:message key="message.email" bundle="${ressourcesBundle}"/></th>
                                            <td><input type="text" class="form-control" name="Email" value="${person.personEmail}" /></td>
                                        </tr>
                                        <tr>
                                            <th scope="col"><fmt:message key="message.login" bundle="${ressourcesBundle}"/></th>
                                            <td><input type="text" class="form-control" name="Login" value="${person.personLogin}" /></td>
                                        </tr>
                                    </tbody>
                                    <tfoot>
                                        <tr id="save">
                                            <th scope="col"></th>
                                            <td class="text-center">
                                                <button class="btn" formaction="saveUser.do"><img src="img/save.png" alt="save" class="icon" /></button>
                                            </td>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/popper.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>
</html>