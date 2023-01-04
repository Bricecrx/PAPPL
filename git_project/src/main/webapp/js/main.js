/**
    ------------------------------------------
    main.js
    
    javascript main functions
    
    JY Martin
    Ecole Centrale Nantes
    ------------------------------------------
*/

// -----------------------------------------------------------------------------

/**
    launchNav
    launch nav action
    @param actionName the action to launch
*/

function launchNav(actionName) {
    if ((actionName !== null) && (actionName !== undefined)) {
        // collect data
        var formRef = document.getElementById("navLaunch");
        var actionRef = document.getElementById("navAction");
        if ((formRef !== null) && (actionRef !== null)) {
            // fill form
            actionRef.value = actionName;
            formRef.action = "navigate.do";
            // launch
            formRef.submit();
        }
    }
}

/**
    launchAction
    launch nav action
    @param actionName the action to launch
    @param dataValue data to take into account
*/

function launchAction(actionName, dataValue) {
    if ((actionName !== null) && (actionName !== undefined)) {
        // collect data
        var formRef = document.getElementById("actionLaunch");
        var actionRef = document.getElementById("launchAction");
        var dataRef = document.getElementById("dataAction");
        if ((formRef !== null) && (actionRef !== null) && (dataRef !== null)) {
            // fill form
            actionRef.value = actionName;
            dataRef.value = dataValue;
            formRef.action = "action.do";
            // launch
            formRef.submit();
        }
    }
}

// -----------------------------------------------------------------------------
/**
 * Launch ajax call
 * @param {type} action
 * @param {type} data
 * @param {type} applySuccess
 * @returns {undefined}
 */
function ajaxCall(action, data, applySuccess) {
    var id_code = document.getElementById("connexion");
    data.connexion = id_code.value;
    data.action = action;

    $.ajax({
        url: "ajax.do",
        data: data,
        method: "POST",
        async: false,
        success: function (result) {
            if (result.ok === 1) {
                applySuccess(result, data);
            } else {
                console.log("refused call " + action);
            }
        },
        error: function (resultat, statut, erreur) {
            console.log("error call " + action + " result = " + resultat + statut + erreur);
        }
    });
}

// -----------------------------------------------------------------------------
function applySuccessRemoveLine(result, data, code) {
    if (result.id > 0) {
        var theTR = document.getElementById(code + result.id);
        if (theTR !== null) {
            theTR.parentNode.removeChild(theTR);
        }
    }
}

function applySuccessAddLineWWithButton(result, data, lineType, nbColumns, actionName, imageName) {
    var arrayReturned = [];
    if (result.id > 0) {
        var lineTD;
        var lineTR;
        var button;
        var lineTypeMaj = (lineType + '').charAt(0).toUpperCase() + lineType.substr(1);

        lineTR = document.createElement("TR");
        lineTR.id = lineType + result.id;

        for (i = 0; i < nbColumns; i++) {
            lineTD = document.createElement("TD");
            lineTD.setAttribute("class", "text-left");
            lineTR.appendChild(lineTD);
            arrayReturned.push(lineTD);
        }

        lineTD = document.createElement("TD");
        lineTD.setAttribute("class", "text-center");
        button = document.createElement("BUTTON");
        button.setAttribute("onclick", actionName + lineTypeMaj + "(" + result.id + ")");
        var img = document.createElement("IMG");
        img.setAttribute("src", "img/"+ imageName + ".png");
        img.setAttribute("alt", actionName);
        img.setAttribute("class", "localButton");
        button.appendChild(img);
        lineTD.appendChild(button);
        lineTR.appendChild(lineTD);

        // Get last line of tbody
        var lineLast = document.getElementById(lineTypeMaj + "List");
        if (lineLast === null) {
            lineLast = document.getElementById(lineType + "List");
        }
        if (lineLast !== null) {
            lineLast = lineLast.firstElementChild;
            while ((lineLast !== null) && (lineLast.tagName !== "TBODY")) {
                lineLast = lineLast.nextElementSibling;
            }
            if (lineLast.tagName === "TBODY") {
                lineLast.append(lineTR);
            }
        
            resetlines(lineLast.nextElementSibling);
        }
    }
    return arrayReturned;
}

function applySuccessAddLineWithDelete(result, data, lineType, nbColumns) {
    return applySuccessAddLineWWithButton(result, data, lineType, nbColumns, "remove", "delete");
}

function applySuccessAddLineWithEdit(result, data, lineType, nbColumns) {
    return applySuccessAddLineWWithButton(result, data, lineType, nbColumns, "edit", "edit");
}

function resetlines(ref) {
    if (ref !== null) {
        if (ref.tagName === "INPUT") {
            ref.value = "";
        } else {
            var elt = ref.firstElementChild;
            while (elt !== null) {
                resetlines(elt);
                elt = elt.nextElementSibling;
            }
        }
    }
}

function addToSelect(selectName, optionId, optionName) {
    var selectRef = document.getElementById(selectName);
    if (selectRef !== null) {
        var lineOption = document.createElement("OPTION");
        lineOption.setAttribute("value", optionId);
        var lineText = document.createTextNode(optionName);
        lineOption.appendChild(lineText);
        
        selectRef.appendChild(lineOption);
    }
}

function removeFromSelect(selectName, optionId) {
    var selectRef = document.getElementById(selectName);
    if (selectRef !== null) {
        var elt = selectRef.firstElementChild;
        var found = null;
        while ((elt !== null) && (found === null)) {
            if (elt.tagName === "OPTION") {
                if (elt.value == optionId) {
                    found = elt;
                }
            }
            elt = elt.nextElementSibling;
        }
        if (found !== null) {
            selectRef.removeChild(found);            
        }
    }
}

// -----------------------------------------------------------------------------

