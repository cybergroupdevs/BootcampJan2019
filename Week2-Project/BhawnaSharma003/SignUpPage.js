function validation(){
    var name = document.getElementById('name').value;
    var employmentid = document.getElementById('employmentid').value;
    var email = document.getElementById('email').value;
    var password = documnet.getElementById("password").value;
    var confirmpassword = document.getElementById('confirmpass').value;

    if (name ==""){
         alert("Please fill the name");
         return false; 
    }
    else if((name.length <=2) || (name.length>20)) {
         alert( "Username must be between 2 and 20");
         return false;
    }
    else if(!isNAN(name)){
         alert("Only characters are allowed");
         return false;   
    }
    else if (employmentid ==""){
         alert("Please fill the Employment Id details");
         return false;  
    }
    else if (email ==""){
    	 alert("Please fill the email details");	
         return false;	
    }
    else if (email.indexOf('@')<=0){
    	 alert("Invalid @ Position");
         return false;	
    }
    else if((email.charAt(email.length-4)!='.') && (email.charAt(email.length-3)!='.')){
    	 alert("Invalid dot Position");
         return false;
    }
    else if (password ==""){
    	 alert("Please fill the password details");
         return false;	
    }
    else if((password.length <=5)||(password.length>20)){
    	 alert("Password length must be between 5 and 20");
         return false;
    }
    else if (confirmpassword ==""){
         alert("Please confirm the password details");
         return false;  
    }
    else if (password!=confirmpassword){
         alert("Passwords do not match");
         return false;
    }
    else{
        window.location="EnterDetails.html";
        return true;
    }

}
