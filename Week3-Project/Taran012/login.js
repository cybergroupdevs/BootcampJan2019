function myfunc(){
    
    var username = document.getElementById("name").value;
    var password = document.getElementById("password").value;
    if(username == ""){
        alert("Username is missing");
    }
    else if(password == ""){
        alert("Password is missing");
    }
//    var myOBJ = {username,password};
//    console.log(myOBJ);
//    var myJSON = JSON.stringify(loginid);
    
    window.location.href = "DataList3.html";
}