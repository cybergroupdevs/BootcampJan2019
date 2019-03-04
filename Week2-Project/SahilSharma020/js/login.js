$(document).ready(function(){
  console.log("hello");

  var submit_btn = document.getElementById('submit_btn');

  submit_btn.addEventListener('click',function(e){

    e.preventDefault();
    var username = document.getElementById('username').value;
    // console.log(username);
    var password = document.getElementById('password').value;
    // console.log(password);

    var url = "http://localhost:63099/api/users";
    $.ajax({url:url,success:function(result){
      // console.log(result);
      // console.log(Object.values(result).indexOf('username'));
      for(var i=0;i<result.length;i++){
        if(result[i].username==username){
          if(result[i].password == password){
            alert('login successful');
            window.location = "home.html";
          }
          else {
            alert('wrong password');
          }
        }
      }
      alert("no user with this username");
    }});

    // if(username && (password.length>7)){
    //   console.log("details entered");
    // }
    // else {
    //   console.log("invalid details. validate username or password");
    // }
  });

});
