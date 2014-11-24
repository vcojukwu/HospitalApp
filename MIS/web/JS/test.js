(function(window, document) {

    var layout = document.getElementById('layout'),
            menu = document.getElementById('menu'),
            menuLink = document.getElementById('menuLink');

    function toggleClass(element, className) {
        var classes = element.className.split(/\s+/),
                length = classes.length,
                i = 0;

        for (; i < length; i++) {
            if (classes[i] === className) {
                classes.splice(i, 1);
                break;
            }
        }
        // The className is not found
        if (length === classes.length) {
            classes.push(className);
        }

        element.className = classes.join(' ');
    }

    menuLink.onclick = function(e) {
        var active = 'active';

        e.preventDefault();
        toggleClass(layout, active);
        toggleClass(menu, active);
        toggleClass(menuLink, active);
    };

}(this, this.document));

function showAdv1() {
    var elem = document.getElementById("adv1");
    var attr = elem.getAttribute("type");
    if (attr === "hidden") {
        elem.setAttribute("type", "number");
        document.getElementById("adv3").setAttribute("type", "date");
        document.getElementById("adv2").style.display = "block";
    }
    else {
        elem.setAttribute("type", "hidden");
        document.getElementById("adv3").setAttribute("type", "hidden");
        document.getElementById("adv2").style.display = "none";
    }
}

function enable() {
    document.getElementById("streetNumber").disabled = false;
    document.getElementById("streetName").disabled = false;
    document.getElementById("city").disabled = false;
    document.getElementById("state").disabled = false;
    document.getElementById("zip").disabled = false;
    document.getElementById("phone").disabled = false;
    //document.getElementById("email").disabled = false;
}

function showForm(elem){
    var selected = elem.value;
    if(selected == 3){
            document.getElementById("sinDiv").style.display = "none";
            document.getElementById("healthDiv").style.display = "none";
            document.getElementById("docDiv").style.display = "none";
            document.getElementById("doctorIdDiv").style.display = "none";
            document.getElementById("healthStateIdDiv").style.display = "none";
    }
    else if(selected == 1){
            document.getElementById("sinDiv").style.display = "block";
            document.getElementById("healthDiv").style.display = "block";
            document.getElementById("docDiv").style.display = "none";
            document.getElementById("doctorIdDiv").style.display = "block";
            document.getElementById("healthStateIdDiv").style.display = "block";
    }
    else{
            document.getElementById("sinDiv").style.display = "none";
            document.getElementById("healthDiv").style.display = "none";
            document.getElementById("docDiv").style.display = "block";
            document.getElementById("doctorIdDiv").style.display = "none";
            document.getElementById("healthStateIdDiv").style.display = "none";
    }
}

function addRow() {
    var div = document.createElement('div');

    div.innerHTML = '<label for="doctor"></label>\
                <select id="doctor" class="pure-input-1-2">\
                    <option>1</option>\
                    <option>2</option>\
                    <option>3</option>\
                </select>';
    div.style.width = "50%";
    div.style.marginLeft = "50%";

    document.getElementById('dynamic_content').appendChild(div);
    document.getElementById("remove").disabled = false;
}

function deleteRow() {
    document.getElementById('dynamic_content').lastChild.remove();
    if (document.getElementById('dynamic_content').childNodes.length == 5) {
        document.getElementById("remove").disabled = true;
    }
}