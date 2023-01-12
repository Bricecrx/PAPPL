/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */

function applySuccessaddSkillObservation(result, data) {
    var columns = applySuccessAddLineWithDelete(result, data, "annee", 2);

    if (columns.length === 2) {
        var lineTD;
        var lineText;

        lineTD = columns[0];
        lineText = document.createTextNode(data.anneeAnnee);
        lineTD.appendChild(lineText);

        lineTD = columns[1];
        lineText = document.createTextNode(data.anneeLib);
        lineTD.appendChild(lineText);
        
        addToSelect("proganneeId", result.id, data.anneeLib);
    }
}

function addSkillObservation() {
    
    var data = new Object();
    data.studentId = document.getElementById('personId').value;
    data.componentId = document.getElementById("componentId").value;
    data.currLevelId = document.getElementById("currLevelId").value;
    data.newLevelId = document.getElementById("newLevelId").value;
    
    ajaxCall("addObservation", data, applySuccessAddAnnee);
}


function showSkills(id) {
    launchAction("showSkills", id);
}

function editSkill(idComponent, idPerson){
    var ids = idComponent + " " + idPerson;
    launchAction("editSkill", ids);
}
