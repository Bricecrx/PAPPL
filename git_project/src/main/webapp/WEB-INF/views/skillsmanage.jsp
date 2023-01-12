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
  <script src="js/functions_observer.js"></script>
  <title>Neptune APP</title>
</head>

<body>
  <%@ include file="header.jspf" %>
  <div class="py-5">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
            <h2 class=""><fmt:message key="message.manageskills" bundle="${ressourcesBundle}"/></h2>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
            <fmt:message key="message.listcourses" bundle="${ressourcesBundle}"/>
        </div>
        <div class="col-md-2">
            <select id="cours" name="cours">
                <option value="*">*</option>
                <c:forEach var="aCourse" items="${courseList}" varStatus="count">
                    <option id="${aCourse.courseAbrev}" value="${aCourse.courseAbrev}">${aCourse.courseAbrev}</option>
                </c:forEach>
            </select>
        </div>
         <div>
        <div class="col-md-10">
            <table id="anneeList"  class="table table-striped table-md">
                <thead>
                    <tr>
                        <th scope="col" class="table-md-2"><fmt:message key="message.lastname" bundle="${ressourcesBundle}"/></th>
                        <th scope="col" class="table-md-9"><fmt:message key="message.firstname" bundle="${ressourcesBundle}"/></th>
                        <th scope="col" class="table-md-9">Cours</th>
                        <th scope="col" class="table-md-1"></th>
                    </tr>
                </thead>
                <tbody id="listeEleves">
                    <c:forEach var="aStudent" items="${courseStudentList}" varStatus="count">
                        <%-- <c:if test="${aStudent[2]==(this).find('option:selected').attr('id')}"> </c:if> --%>
                        <tr id="colonne">
                            <td class="text-left">${aStudent[1]}</td>
                            <td class="text-left">${aStudent[2]}
                            <td class="text-left">
                                <c:forEach begin="3" end="${aStudent.size()}" var="i" step="1">
                                    ${aStudent[i]}      
                                </c:forEach>
                            </td>
                            <td class="text-center">
                                <button onClick="showSkills(${aStudent[0]})"><img src="img/edit.png" alt="Edit" class="localButton" /></button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
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