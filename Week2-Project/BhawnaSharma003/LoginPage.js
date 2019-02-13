function validation(){
    var user = document.getElementById('email').value;
    var password = documnet.getElementById("password").value;

    if (email ==""){
    	document.getElementById("email").innerHTML = "** Please fill the email details";
    	return false;	
    }
    if (email.indexOf(@)<=0){
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
    if(password.length <=5)||(password.length>20){
    	document.getElementById("password").innerHTML = "** Password length must be between 5 and 20";
    	return false;	
    }

}