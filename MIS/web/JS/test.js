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
                document.getElementById("patId").value = row[0].value;
		document.getElementById("patName").value = row[1].value;
		document.getElementById("docId").value = row[2].value;
		document.getElementById("docName").value = row[3].value;
		document.getElementById("time").value = row[4].value;
		document.getElementById("duration").value = row[5].value;
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
		document.getElementById("selectedNotes").value = row[5].value;
                document.getElementById("selectedOriginalRecordId").value = row[6].value;
                document.getElementById("selectedRecordId").value = row[7].value;
                document.getElementById("selectedRecordType").value = row[8].value;
                
                
                //Submit form
                document.getElementById('submitRecords').click();
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

function addRowPatientRecord(r){
    
        var dt = new Date();
        var newdate =dt.getFullYear() + "-" + (dt.getMonth() + 1) + "-" + dt.getDate();
        var timenow = dt.getHours() + ":" + dt.getMinutes();
	var i = r.parentNode.parentNode.rowIndex;
	var table = document.getElementById("records");
	var row = table.insertRow(i);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
	var cell5 = row.insertCell(4);
	var cell6 = row.insertCell(5);
	var cell7 = row.insertCell(6);
        var tmp = '${procedures.getProcedureId()}';
        var tmp2 = '${procedures.getProcedureName()}';
        var tmp3 = '${procedures}';
	
	cell1.innerHTML = '<select id="procedureId" name="procedureId">\
                                    <c:forEach items="\${procedures}" var="procedures" >\
                                        <option value="\${procedures.getProcedureId()}">\${procedures.getProcedureName()}</option>\
                                    </c:forEach>\
                                </select>';
	cell2.innerHTML = '<input id="date" type="date" value ="' + newdate + '">';
        cell3.innerHTML = '<input id="timestarted" type="time" value="' + timenow + '" >';
	cell4.innerHTML = '<input id="timeended" type="time" value="' + timenow + '" >';
	cell5.innerHTML = '<input id="precriptions" type="text" value ="" >';
	cell6.innerHTML = '<input id="Diagnosis" type="text" value ="" >';
	cell7.innerHTML = '<input id="notes" type="text" value = "" >';
        cell8.innerHTML = '<input class="duration" style="width:100%" type="number" value = "60">';
	cell7.innerHTML = '<button title="Save" value="PatientRecord" name="PatientRecord" onclick="enableRowPatientRecord(this); \
                                    return false" style="margin-right:15%; margin-left:15%" class="pure-button">\
                                    <i class="fa fa-floppy-o"></i>\
                           </button>';
    return false;
}
