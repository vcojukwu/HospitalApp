(function (window, document) {

    var layout   = document.getElementById('layout'),
        menu     = document.getElementById('menu'),
        menuLink = document.getElementById('menuLink');

    function toggleClass(element, className) {
        var classes = element.className.split(/\s+/),
            length = classes.length,
            i = 0;

        for(; i < length; i++) {
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

    menuLink.onclick = function (e) {
        var active = 'active';

        e.preventDefault();
        toggleClass(layout, active);
        toggleClass(menu, active);
        toggleClass(menuLink, active);
    };

}(this, this.document));

function showAdv1(){
	var elem = document.getElementById("adv1");
	var attr = elem.getAttribute("type");
	if(attr === "hidden"){
		elem.setAttribute("type","number");
		document.getElementById("adv3").setAttribute("type","date");
		document.getElementById("adv2").style.display = "block";
	}
	else{
		elem.setAttribute("type","hidden");
		document.getElementById("adv3").setAttribute("type","hidden");
		document.getElementById("adv2").style.display = "none";
		}
}

function enable(){
	document.getElementById("address").disabled = false;
	document.getElementById("city").disabled = false;
	document.getElementById("state").disabled = false;
	document.getElementById("zip").disabled = false;
	document.getElementById("phone").disabled = false;
	document.getElementById("email").disabled = false;
}