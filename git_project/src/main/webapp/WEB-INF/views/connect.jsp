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
          <h2 class="">Please login</h2>
        </div>
      </div>
      <div class="row">
        <div class="col-md-12">
            <form id="c_form-h" class="" action="connect.do" method="POST">
            <div class="form-group row"> <label for="inputmailh" class="col-2 col-form-label"><fmt:message key="message.login" bundle="${ressourcesBundle}"/></label>
              <div class="col-10">
                <input type="text" class="form-control" id="inputmailh" placeholder="<fmt:message key="message.login" bundle="${ressourcesBundle}"/>" name="login" required="required"> </div>
            </div>
            <div class="form-group row"> <label for="inputpasswordh" class="col-2 col-form-label"><fmt:message key="message.password" bundle="${ressourcesBundle}"/></label>
              <div class="col-10">
                <input type="password" class="form-control" id="inputpasswordh" placeholder="<fmt:message key="message.password" bundle="${ressourcesBundle}"/>" name="password" required="required"> </div>
            </div>
            <button type="submit" class="btn btn-primary"><fmt:message key="message.connect" bundle="${ressourcesBundle}"/></button>
          </form>
        </div>
      </div>
    </div>
  </div>
  <%@ include file="footer.jspf" %>
  <script src="js/popper.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
</body>

</html>