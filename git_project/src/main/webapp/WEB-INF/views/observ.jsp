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
            <p>Test</p>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <form>
                                <table id="parameters"  class="table table-striped table-sm">
                                    <tr>
                                        <td class="text-center">
                                            <select name="diplomeId" id="diplomeId" onChange="selectObserv()">
                                                <c:forEach var="item" items="${listDiplom}">
                                                    <option value="${item.diplomId}">${item.diplomName}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td class="text-center">
                                            <select name="anneeId" id="anneeId" onChange="selectObserv()">
                                                <c:forEach var="item" items="${listAcademicyear}">
                                                    <option value="${item.academicyearId}">${item.academicyearTitle}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td class="text-center" rowspan=""2"><button onClick="selectObserv()"><img src="img/select.png" alt="select" class="localButton" /></button></td>
                                    </tr>
                                    <tr>
                                        <td class="text-center">
                                            <select name="groupeId" id="groupeId0" onChange="selectObserv()">
                                                <c:forEach var="item" items="${listGroupes}">
                                                    <option value="${item.stdentgroupId}">${item.stdentgroupName}</option>
                                                </c:forEach>
                                            </select>
                                        </td>
                                        <td class="text-center">
                                            <c:forEach var="item" items="${listObserv}">
                                                <option value="${item.observationpointId}">${item.observationpointName}</option>
                                            </c:forEach>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="row">
                    <hr/>
                    <div class="col-md-12"><h3><fmt:message key="message.anneeuniversitaire" bundle="${ressourcesBundle}"/></h3></div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table id="anneeList"  class="table table-striped table-sm">
                                <c:forEach var="item" items="${anneesList}" varStatus="count">
                                    <tr id="annee${item.academicyearId}">
                                        <td class="text-left">${item.academicyearYear}</td>
                                        <td class="text-left">${item.academicyearTitle}</td>
                                        <td class="text-center"><c:if test="${empty item.programCollection}"><button onClick="removeAnnee(${item.academicyearId})"><img src="img/delete.png" alt="remove" class="localButton" /></button></c:if></td>
                                        </tr>
                                </c:forEach>
                                <tr id="lineAddAnnee">
                                    <td class="text-left"><input type="text" name="anneeAnnee" id="anneeAnnee" class="form-control" placeholder="year" value="" size="5" /></td>
                                    <td class="text-left"><input type="text" name="anneeLib" id="anneeLib" class="form-control" placeholder="libelle" value="" /></td>
                                    <td class="text-center col-md-1"><button onClick="addAnnee()"><img src="img/plus.png" alt="add" class="localButton" /></button></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-md-12"><h3><fmt:message key="message.diplome" bundle="${ressourcesBundle}"/></h3></div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table id="diplomeList"  class="table table-striped table-sm">
                                <c:forEach var="item" items="${diplomeList}" varStatus="count">
                                    <tr id="diplome${item.diplomId}">
                                        <td class="text-left">${item.diplomName}</td>
                                        <td class="text-center"><c:if test="${empty item.programCollection}"><button onClick="removeDiplome(${item.diplomId})"><img src="img/delete.png" alt="remove" class="localButton" /></button></c:if></td>
                                        </tr>
                                </c:forEach>
                                <tr id="lineAddDiplome">
                                    <td class="text-left"><input type="text" name="diplomeLib" id="diplomeLib" class="form-control" placeholder="libelle" value="" /></td>
                                    <td class="text-center col-md-1"><button onClick="addDiplome()"><img src="img/plus.png" alt="add" class="localButton" /></button></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-md-12"><h3><fmt:message key="message.programme" bundle="${ressourcesBundle}"/></h3></div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive">
                            <table id="programList"  class="table table-striped table-sm">
                                <c:forEach var="item" items="${programList}" varStatus="count">
                                    <tr id="program{
                                            item.programId
                                        }">
                                        <td class="text-left">${item.academicyearId.academicyearTitle}</td>
                                        <td class="text-left">${item.diplomId.diplomName}</td>
                                        <td class="text-center"><c:if test="${empty item.studentgroupCollection}"><button onClick="removeProgram(${item.programId})"><img src="img/delete.png" alt="remove" class="localButton" /></button></c:if></td>
                                        </tr>
                                </c:forEach>
                                <tr id="lineAddProgram">
                                    <td class="text-center">
                                        <select name="proganneeId">
                                            <option value="-1">-</option>
                                            <c:forEach var="item" items="${anneesList}" varStatus="count">
                                                <option value="${item.academicyearId}">${item.academicyearTitle}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td class="text-center">
                                        <select name="progdiplomeId">
                                            <option value="-1">-</option>
                                            <c:forEach var="item" items="${programList}" varStatus="count">
                                                <option value="${item.diplomId}">${item.diplomName}</option>
                                            </c:forEach>
                                        </select>
                                    </td>
                                    <td class="text-center col-md-1"><button onClick="addProgram()"><img src="img/plus.png" alt="add" class="localButton" /></button></td>
                                </tr>
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