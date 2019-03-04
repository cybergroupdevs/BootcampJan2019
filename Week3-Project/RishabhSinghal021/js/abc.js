var counter=0;
function abc(){
	counter=0;
	if(counter==0){
		document.getElementById("heading").innerHTML="Login";
		document.getElementById("sign").style.display = 'none';
		document.getElementById("signup").style.display = 'none';
		document.getElementById("login").style.display = 'block';
		document.getElementById("log").style.display = 'block';
		//document.getElementById("heading").innerHTML="Login";
	}
}
function abc1(){
	counter=1;
	if(counter==1){
		document.getElementById("heading").innerHTML="Sign_up";
		document.getElementById("sign").style.display = 'block';
		document.getElementById("signup").style.display = 'block';
		document.getElementById("login").style.display = 'none';
		document.getElementById("log").style.display = 'none';
		//document.getElementById("heading").innerHTML="Login";
	}
}

function loginq(){
	var name = document.getElementById("userid").value;
	var pass = document.getElementById("password").value;
	$.ajax({
        url: 'http://localhost:8083/employee/'+ name,
        type: 'GET',
        dataType: 'json',
        success: function(res){
			console.log(res);
            if(pass == res[0].password){
				console.log(res.id);
				localStorage.setItem('Id', res[0].id);
                window.location = "project.html";
            }
            else{
                alert("wrong id or password");
            }
        }
    });
}

function signup(){
	var name = document.getElementById("userid").value;
	var pass = document.getElementById("password").value;
	console.log(name);
	console.log(pass);
	var data= {
        "name": name,
        "password": pass
    };
	console.log(data);
	$.ajax({
        url: 'http://localhost:8083/employee',
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





