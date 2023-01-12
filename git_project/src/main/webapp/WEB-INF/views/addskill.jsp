+<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="fr.centrale.nantes.neptune.ressources.messages" var="ressourcesBundle" />
<fmt:setBundle basename="fr.centrale.nantes.neptune.ressources.menu" var="ressourcesBundle" />
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/thomas.css">
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script src="js/main.js"></script>
        <script src="js/functions.js"></script>
        <script src="js/functions_observer.js"></script>
        <title>Neptune APP</title>
    </head>
    <body>
        <%@ include file="header.jspf" %>
        
        
    <div class="container">

        <form class="well form-horizontal" action=" " method="post"  id="contact_form">
    <fieldset>

    <!-- Select Basic -->
    <div class="py-5">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="">Edition de la compétence "${component.componentName}"</h2>
                    <h3 class="">${person.personFirstname} ${person.personLastname}</h3>
                    <input type="hidden" id="componentId" value="${component.componentId}"/>
                    <input type="hidden" id="currLevelId" value="${levelId}"/>
                    <input type="hidden" id="personId" value="${person.personId}"/>
                </div>
            </div>
        </div>
    </div>

        
    <!-- Select Basic -->
    <div class="form-group"> 
      <label class="col-md-4 control-label">Niveau</label>
        <div class="col-md-4 selectContainer">
        <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
        <select id="newLevelId" name="state" class="form-control selectpicker" >
          <option value=" " >Selectionnez le niveau de l'étudiant</option>
          <option value="1">Novice</option>
          <option value="2">Intermédiaire</option>
          <option value="3">Compétent</option>
          <option value="4">Avancé</option>
          <option value="5">Expert</option>
          
        </select>
      </div>
    </div>
    </div>

    <!-- Text input-->

    <div class="form-group">
      <label class="col-md-4 control-label">Commentaire</label>  
        <div class="col-md-4 inputGroupContainer">
        <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
      <input name="Commentaire" placeholder="Commentaire" class="form-control"  type="text">
        </div>
    </div>
    </div>

    

  

    <!-- Success message <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i><div> -->
    

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label"></label>
      <div class="col-md-4">
          <input class="btn btn-warning" id="clickMe" type="button" value="Ajouter" onclick="addSkillObservation()" />
        <!--<button onClick="addSkillObservation()">Ajouter</button>-->
      </div>
    </div>

    </fieldset>
    </form>
    </div>


        
        
        
        <%@ include file="footer.jspf" %>
        <script src="js/popper.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </body>

</html>