function myfunc(){
    var fields = ["fname","lname","email","password"];

    
    for(var i =0;i<4;i++){
        var x = document.forms["myForm"][fields[i]].value;
        if (x == "") {
            alert("All fields are required");
            return false;
        }
    }
    window.location.href = "login.html";
//    var FName = document.getElementById("fname").value;
//    var LName = document.getElementById("lname").value;
//    var email = document.getElementById("email").value;
//    var password = document.getElementById("password").value;
//    
//    var myOBJ = {
//        FName,LName,email,password
//    }    
//    console.log(myOBJ);
//    var myJSON = JSON.stringify(myOBJ);
// 

}