function getEmployee(){
	var emp = localStorage.getItem("Id");
    $.ajax({
        url: 'http://localhost:8083/project/'+emp,
        type: 'GET',
        dataType: 'json',
        success: function(res){
            var table = document.getElementById("mtable");
            for(var i=0;i<res.length;i++){
				var row = table.insertRow(table.length);
                row.insertCell(0).innerHTML = res[i].id;
                row.insertCell(1).innerHTML = res[i].name;
                row.insertCell(2).innerHTML = "<input type='button' value='Edit' id='button' data-toggle='modal' data-target='#myModal' onclick=\'fetch(\""+res[i].id +"\",\""+res[i].name+"\")\'>" 
                row.insertCell(3).innerHTML = "<input type='button' value='delete' id='button' onclick=\'deleteProject(\""+res[i].id+"\")\'>"
            }

        }
    });
}

function fetch(id, name){
	document.getElementById("projectid").value = id;
	document.getElementById("projectname").value = name;
}

function update(){
	var name = document.getElementById("project");
	var emp = localStorage.getItem("Id");
	var data= {
        "name": name,
        "password": pass
    };
	$.ajax({
        url: 'http://localhost:8083/project',
		contentType: "application/json",
		data: JSON.stringify(data),
        type: 'PUT',
        dataType: 'json',
        success: function(res){
			console.log("success");
            window.location = "project.html";
        }
    });
}

function addProject(){
	var name = document.getElementById("project");
	var emp = localStorage.getItem("Id");
	var data= {
        "name": name,
        "password": pass
    };
	$.ajax({
        url: 'http://localhost:8083/project',
		contentType: "application/json",
		data: JSON.stringify(data),
        type: 'POST',
        dataType: 'json',
        success: function(res){
			console.log("success");
			localStorage.setItem('id', id);
			localStorage.setItem('pass', password);
            window.location = "project.html";
        }
    });
}

function deleteProject(id){
	console.log("done");
	var check = confirm("Are you Sure, you want to delete");
	if(check == true){
	    $.ajax({
		url: 'http://localhost:8083/project/'+id,
        type: 'DELETE',
        success: function (resource){
			console.log("done with deletion");
            window.location = "project.html";
			}
		});	
	}

}
