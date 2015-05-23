function addRow() {
         
    var serviceName = document.getElementById("serviceName");
    var portNumber = document.getElementById("port");
    var serviceType = document.getElementById("type");
    var table = document.getElementById("tableData");

    var rowCount = table.rows.length;
    var row = table.insertRow(rowCount);

    row.insertCell(0).innerHTML= serviceName.value;
    row.insertCell(1).innerHTML= portNumber.value;
	row.insertCell(2).innerHTML= serviceType.value;
	row.insertCell(3).innerHTML= '<input type="button" value = "Delete" onClick="Javacsript:deleteRow(this)">';
}

function deleteRow(obj) {
     
    var index = obj.parentNode.parentNode.rowIndex;
    var table = document.getElementById("tableData");
    table.deleteRow(index);
}

function reset(){
	document.getElementById("form").reset();
}

function validateForm() {
	var x = document.forms["form"]["serviceName"].value;
	var y = document.forms["form"]["port"].value;
	var z = document.forms["form"]["type"].value;
    if (x == null || x == "" || y == null || y =="" || z == null || z == "") {
        alert("All fields must be filled out!");
        return false;
    }
	addRow();
	reset();
}
