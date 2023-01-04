/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */

function editGroup(id) {
    launchAction("editGroup", id);
}

function addGroup() {
    var data = new Object();
    data.groupName = document.getElementById("groupName").value;
    ajaxCall("addGroup", data, applySuccessAddGroup);
}

function applySuccessAddGroup(result, data) {
    var columns = applySuccessAddLineWithEdit(result, data, "group", 1);

        if (columns.length === 1) {
        var lineTD;
        var lineText;

        lineTD = columns[0];
        lineText = document.createTextNode(data.personFirstname);
        lineTD.appendChild(lineText);
    }
}



