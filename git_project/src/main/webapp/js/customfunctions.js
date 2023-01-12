/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */


function addStudent() {
    var data = new Object();
    data.personFirstname = document.getElementById("personFirstname").value;
    data.personLastname = document.getElementById("personLastname").value;
    data.personEmail = document.getElementById("personEmail").value;
    ajaxCall("addStudent", data, applySuccessAddStudent);
}

function applySuccessAddStudent(result, data) {
    var columns = applySuccessAddLineWithEdit(result, data, "student", 3);

    if (columns.length === 3) {
        var lineTD;
        var lineText;

        lineTD = columns[0];
        lineText = document.createTextNode(data.personFirstname);
        lineTD.appendChild(lineText);

        lineTD = columns[1];
        lineText = document.createTextNode(data.personLastname);
        lineTD.appendChild(lineText);

        lineTD = columns[2];
        lineText = document.createTextNode(data.personEmail);
        lineTD.appendChild(lineText);
        
        
        lineTD = columns[3];
        alert(result.id2);
        lineText = "0125415"; //document.createTextNode(result.id2);
        lineTD.appendChild(lineText);
    }

    
}
