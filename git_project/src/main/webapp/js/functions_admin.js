/**
 ------------------------------------------
 functions_admin.js
 
 javascript functions for practical work
 
 JY Martin
 Ecole Centrale Nantes
 ------------------------------------------
 */

// -----------------------------------------------------------------------------
/**
 * 
 * @param {type} result
 * @param {type} data
 * @returns {undefined}
 */
function applySuccessRemoveAnnee(result, data) {
    applySuccessRemoveLine(result, data, "annee");
//    removeFromSelect("proganneeId", result.id);
}

function removeAnnee(annee) {
    var data = new Object();
    data.anneeId = annee;
    ajaxCall("removeAnnee", data, applySuccessRemoveAnnee);
}

function applySuccessAddAnnee(result, data) {
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

function addAnnee() {
    var data = new Object();
    data.anneeLib = document.getElementById("anneeLib").value;
    data.anneeAnnee = document.getElementById("anneeAnnee").value;

    ajaxCall("addAnnee", data, applySuccessAddAnnee);
}

// -----------------------------------------------------------------------------

function applySuccessRemoveDiplome(result, data) {
    applySuccessRemoveLine(result, data, "diplome");
//    removeFromSelect("progdiplomeId", result.id);
}

function removeDiplome(annee) {
    var data = new Object();
    data.diplomeId = annee;
    ajaxCall("removeDiplome", data, applySuccessRemoveDiplome);
}

function applySuccessAddDiplome(result, data) {
    var columns = applySuccessAddLineWithDelete(result, data, "diplome", 1);

    if (columns.length === 1) {
        var lineTD;
        var lineText;

        lineTD = columns[0];
        lineText = document.createTextNode(data.diplomeLib);
        lineTD.appendChild(lineText);

        addToSelect("progdiplomeId", result.id, data.diplomeLib);
    }
}

function addDiplome() {
    var data = new Object();
    data.diplomeLib = document.getElementById("diplomeLib").value;

    ajaxCall("addDiplome", data, applySuccessAddDiplome);
}

// -----------------------------------------------------------------------------
function applySuccessRemoveProgram(result, data) {
    applySuccessRemoveLine(result, data, "program");
}

function removeProgram(program) {
    var data = new Object();
    data.programId = program;
    ajaxCall("removeProgram", data, applySuccessRemoveProgram);
}

function applySuccessAddProgram(result, data) {
    var columns = applySuccessAddLineWithDelete(result, data, "program", 2);

    if (columns.length === 2) {
        var lineTD;
        var lineText;

        lineTD = columns[0];
        lineText = document.createTextNode(result.annee);
        lineTD.appendChild(lineText);

        lineTD = columns[1];
        lineText = document.createTextNode(result.diplom);
        lineTD.appendChild(lineText);
        
        var refA = document.document.getElementById("proganneeId");
        refA.selected=0;
        var refD = document.document.getElementById("progdiplomeId");
        refD.selected=0;
    }
}

function addProgram() {
    var data = new Object();
    data.anneeId = document.getElementById("proganneeId").value;
    data.diplomeId = document.getElementById("progdiplomeId").value;

    ajaxCall("addProgram", data, applySuccessAddProgram);
}

// -----------------------------------------------------------------------------
function applySuccessRemoveCourse(result, data) {
    applySuccessRemoveLine(result, data, "course");
}

function removeCourse(course) {
    var data = new Object();
    data.courseId = course;
    ajaxCall("removeCourse", data, applySuccessRemoveCourse);
}

function applySuccessAddCourse(result, data) {
    var columns = applySuccessAddLineWithEdit(result, data, "course", 2);

    if (columns.length === 2) {
        var lineTD;
        var lineText;

        lineTD = columns[0];
        lineText = document.createTextNode(data.courseTitle);
        lineTD.appendChild(lineText);

        lineTD = columns[1];
        lineText = document.createTextNode(data.courseAbrev);
        lineTD.appendChild(lineText);
    }
}

function addCourse() {
    var data = new Object();
    data.courseTitle = document.getElementById("courseTitle").value;
    data.courseAbrev = document.getElementById("courseAbrev").value;
    data.programId = document.getElementById("programId").value;

    ajaxCall("addCourse", data, applySuccessAddCourse);
}

function editCourse(id) {
    launchAction("editCourse", id);
}

// -----------------------------------------------------------------------------
