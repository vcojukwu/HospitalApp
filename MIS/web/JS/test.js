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

function showAdv1(){
	var elem = document.getElementById("firstname");
	var attr = elem.getAttribute("type");
	if(attr == "hidden"){
		elem.setAttribute("type","text");
		document.getElementById("lastname").setAttribute("type","text");
		document.getElementById("adv2").style.display = "block";
		document.getElementById("adv3").setAttribute("type","date");
		document.getElementById("advSearch").innerHTML = "Regular Search";
	}
	else{
		elem.setAttribute("type","hidden");
		document.getElementById("lastname").setAttribute("type","hidden");
		document.getElementById("adv2").style.display = "none";
		document.getElementById("adv3").setAttribute("type","hidden");
		document.getElementById("advSearch").innerHTML = "Advanced Search";
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
            document.getElementById("dynamic_content").style.display = "block";
    }
    else if(selected == 1){
            document.getElementById("sinDiv").style.display = "block";
            document.getElementById("healthDiv").style.display = "block";
            document.getElementById("docDiv").style.display = "none";
            document.getElementById("doctorIdDiv").style.display = "block";
            document.getElementById("healthStateIdDiv").style.display = "block";
            document.getElementById("dynamic_content").style.display = "none";
    }
    else{
            document.getElementById("sinDiv").style.display = "none";
            document.getElementById("healthDiv").style.display = "none";
            document.getElementById("docDiv").style.display = "block";
            document.getElementById("doctorIdDiv").style.display = "none";
            document.getElementById("healthStateIdDiv").style.display = "none";
            document.getElementById("dynamic_content").style.display = "none";
    }
}

function deleteRow() {
    document.getElementById('dynamic_content').lastChild.remove();
    if (document.getElementById('dynamic_content').childNodes.length == 5) {
        document.getElementById("remove").disabled = true;
    }
}

function enableRow(elem){
    if(elem.getAttribute("name") == "Edit"){
        elem.setAttribute('name','Save');
        elem.setAttribute('type', 'submit');

        elem.setAttribute('value', 'Save');
        elem.setAttribute('onClick', 'enableRow(this);');
        var row = elem.parentNode.parentNode.getElementsByClassName("rowData");
        for(var i=0;i<row.length;i++){
            row[i].disabled = false;
        }
    }
    else {           
        var row = elem.parentNode.parentNode.getElementsByClassName("rowData");
        for(var i=0;i<(row.length);i++){
            row[i].disabled = true;
        }        
        if(elem.getAttribute("name") == "Add") {
            document.getElementById("function").value = "AddAppointment";
            //document.getElementById("appointmentIdFinal").value    = row[0].value;
            document.getElementById("patIdFinal").value    = row[0].value;
            document.getElementById("docIdFinal").value    = row[1].value;
            document.getElementById("dateFinal").value     = row[2].value;
            document.getElementById("timeFinal").value     = row[3].value;
            document.getElementById("durationFinal").value = row[4].value;
        }
        else {
            document.getElementById("function").value = "EditAppointment";
            document.getElementById("appointmentIdFinal").value    = row[0].value;
            document.getElementById("patIdFinal").value    = row[1].value;
            document.getElementById("docIdFinal").value    = row[2].value;
            document.getElementById("dateFinal").value     = row[3].value;
            document.getElementById("timeFinal").value     = row[4].value;
            document.getElementById("durationFinal").value = row[5].value;
        }            
        elem.setAttribute('name','Edit');
        elem.setAttribute('type', 'button');
        elem.setAttribute('value', 'Edit');
        elem.setAttribute('onClick', 'enableRow(this); return false');
        document.forms[1].submit();
    }
}

function enableRowPatientRecord(elem){
	if(elem.getAttribute("title") == "Edit"){
		elem.innerHTML='<i class="fa fa-floppy-o"></i>';
		elem.setAttribute('title', 'Save');
		var row = elem.parentNode.parentNode.getElementsByTagName("input");
                var row2 = elem.parentNode.parentNode.getElementsByTagName("select");
		for(var i=0;i<row.length;i++){
			row[i].disabled = false;
		}
                row2[0].disabled = false;
	}
	else{
		elem.innerHTML='<i class="fa fa-pencil"></i>';
		elem.setAttribute('title', 'Edit');
		var row = elem.parentNode.parentNode.getElementsByTagName("input");
                var row2 = elem.parentNode.parentNode.getElementsByTagName("select");
		for(var i=0;i<row.length;i++){
			row[i].disabled = true;
		}
                row2[0].disabled = true;
                document.getElementById("selectedProcedureId").value = row2[0].value;
                document.getElementById("selectedDate").value = row[0].value;
		document.getElementById("selectedTimeStarted").value = row[1].value;
		document.getElementById("selectedTimeEnded").value = row[2].value;
                document.getElementById("selectedPrecriptions").value = row[3].value;
		document.getElementById("selectedDiagnosis").value = row[4].value;
                document.getElementById("selectedTreatmentSchedule").value = row[5].value;
		document.getElementById("selectedNotes").value = row[6].value;
                document.getElementById("selectedOriginalRecordId").value = row[7].value;
                document.getElementById("selectedRecordId").value = row[8].value;
                document.getElementById("selectedRecordType").value = row[9].value;
                
                
                //Submit form
                document.getElementById('submitRecords').click();
	}	
        
}

function deleteRow2(r) {
    var ans = confirm("Are you sure you want to delete appointment?");
    if(ans == true){
        var i = r.parentNode.parentNode.rowIndex;
        document.getElementById("appointments").deleteRow(i);
        document.getElementById("function").value = "DeleteAppointment";
        var row = r.parentNode.parentNode.getElementsByClassName("rowData");
        document.getElementById("appointmentIdFinal").value = row[0].value;
        document.forms[1].submit();
    }    
}

function deleteRow3(r) {
    var i = r.parentNode.parentNode.rowIndex;
    document.getElementById("appointments").deleteRow(i);
}