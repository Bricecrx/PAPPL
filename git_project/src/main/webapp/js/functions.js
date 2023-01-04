/**
 ------------------------------------------
 functions.js
 
 javascript functions for practical work
 
 JY Martin
 Ecole Centrale Nantes
 ------------------------------------------
 */

// -----------------------------------------------------------------------------



// -----------------------------------------------------------------------------
function applySuccessRemovePerson(result, data) {
    applySuccessRemoveLine(result, data, "person");
}

function removePerson(person) {
    var data = new Object();
    data.personId = person;
    ajaxCall("removePerson", data, applySuccessRemovePerson);
}

function applySuccessAddPerson(result, data) {
    var columns = applySuccessAddLineWithEdit(result, data, "person", 3);

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
    }
}

function addPerson() {
    var data = new Object();
    data.personFirstname = document.getElementById("personFirstname").value;
    data.personLastname = document.getElementById("personLastname").value;
    data.personEmail = document.getElementById("personEmail").value;
    
    ajaxCall("addPerson", data, applySuccessAddPerson);
}

function editPerson(id) {
    launchAction("editPerson", id);
}

// -----------------------------------------------------------------------------

