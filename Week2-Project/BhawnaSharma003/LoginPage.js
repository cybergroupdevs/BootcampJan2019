function validation(){
    var email = document.getElementById('email').value;
    var password = document.getElementById("password").value;

    if (email ==""){
    	alert(" Please fill the email details");
    	return false;	
    }
    else if (email.indexOf(@)<=0){
    	alert(" Invalid @ Position");
    	return false;	
    }
    else if((email.charAt(email.length-4)!='.') && (email.charAt(email.length-3)!='.')){
    	alert(" Invalid Dot Position");
    	return false;
    }
    else if (password ==""){
    	alert (" Please fill the password details");
    	return false;	
    }
    else if((password.length <=5)||(password.length>20)){
    	alert("Password length must be between 5 and 20");
    	return false;	
    }
   else {
        window.location="EnterDetails.html";
        return true;
   }

}
