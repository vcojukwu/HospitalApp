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

function deleteRow() {
    document.getElementById('dynamic_content').lastChild.remove();
    if (document.getElementById('dynamic_content').childNodes.length == 5) {
        document.getElementById("remove").disabled = true;
    }
}

function enableRow(elem){
	if(elem.getAttribute("title") == "Edit"){
		elem.innerHTML='<i class="fa fa-floppy-o"></i>';
		elem.setAttribute('title', 'Save');
		var row = elem.parentNode.parentNode.getElementsByTagName("input");
		for(var i=0;i<row.length;i++){
			row[i].disabled = false;
		}
	}
	else{
		elem.innerHTML='<i class="fa fa-pencil"></i>';
		elem.setAttribute('title', 'Edit');
		var row = elem.parentNode.parentNode.getElementsByTagName("input");
		for(var i=0;i<row.length;i++){
			row[i].disabled = true;
		}
	}	
}

function deleteRow2(r) {
    var ans = confirm("Are you sure you want to delete appointment?");
    if(ans == true){
        var i = r.parentNode.parentNode.rowIndex;
    document.getElementById("appointments").deleteRow(i);
    }    
}

function addRow2(r){
	var i = r.parentNode.parentNode.rowIndex;
	var table = document.getElementById("appointments");
	var row = table.insertRow(i);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
	var cell5 = row.insertCell(4);
	var cell6 = row.insertCell(5);
	var cell7 = row.insertCell(6);
	
	cell1.innerHTML = '<input class="patID" type="number" value = "1">';
	cell2.innerHTML = '<input class="patName" type="text" value = "Victor Ojukwu"></td>';
	cell3.innerHTML = '<input class="docID" type="number" value = "1"></td>';
	cell4.innerHTML = '<input class="docName" type="text" value = "John Doe">';
	cell5.innerHTML = '<input class="time" type="datetime" value = "1:00">';
	cell6.innerHTML = '<input class="duration" style="width:100%" type="number" value = "60">';
	cell7.innerHTML = '<button title="Save" onClick="enableRow(this);return false"\
	 					style="margin-right:15%; margin-left:15%" class="pure-button">\
    						<i class="fa fa-floppy-o"></i>\
					  </button><button onClick="deleteRow2(this);return false" class="pure-button">\
   							<i class="fa fa-times-circle"></i>\
					  </button>';
}

function isChecked(){
	var check = document.getElementById("docbyID");
	if(check.checked){
		document.getElementById("docID").style.display = "initial";
		document.getElementById("doc").style.display = "none";
	}
	else {
		document.getElementById("docID").style.display = "none";
		document.getElementById("doc").style.display = "initial";
	}
}