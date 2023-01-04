/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */

function DeleteStudentGroup(studentregistration, group) {
    var data = new Object();
    data.studentregistrationId = studentregistration;
    data.groupId = group;
    ajaxCall("removeStudentFromGroup", data, applySuccessRemoveStudent);
}

function applySuccessRemoveStudent(result, data) {
    applySuccessRemoveLine(result, data, "student");
}


