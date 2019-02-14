function validation(){
    var user = document.getElementById('name').value;
    var user = document.getElementById('employmentid').value;
    var user = document.getElementById('email').value;
    var password = documnet.getElementById("password").value;
    var user = document.getElementById('confirmpassword').value;

    if (name ==""){
        document.getElementById("name").innerHTML = "** Please fill the name details";
        return false;   
    }
    if((name.length <=2) || (name.length>20)) {
        document.getElementById("name").innerHTML = "** Usename must be between 2 and 20";
        return false;   
    }
    if(!isNAN(name)){
        document.getElementById("name").innerHTML = "** Only characters are allowed";
        return false;   
    }
    if (employmentid ==""){
        document.getElementById("email").innerHTML = "** Please fill the Employment Id details";
        return false;   
    }
    if (email ==""){
    	document.getElementById("email").innerHTML = "** Please fill the email details";
    	return false;	
    }
    if (email.indexOf('@')<=0){
    	document.getElementById("email").innerHTML = "** @ Invalid Position";
    	return false;	
    }
    if((email.charAt(email.length-4)!='.') && (email.charAt(email.length-3)!='.')){
    	document.getElementById("email").innerHTML = "** . Invalid Position";
    	return false;
    }
    if (password ==""){
    	document.getElementById("password").innerHTML = "** Please fill the password details";
    	return false;	
    }
    if((password.length <=5)||(password.length>20)){
    	document.getElementById("password").innerHTML = "** Password length must be between 5 and 20";
    	return false;	
    }
    if (confirmpassword ==""){
        document.getElementById("email").innerHTML = "** Please confirm the password details";
        return false;   
    }
    if (password!=confirmpassword){
        document.getElementById("email").innerHTML = "** Passwords do not match";
        return false;   
    }

}