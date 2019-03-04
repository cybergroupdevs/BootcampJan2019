$(document).ready(function(){
  console.log("hello");

  var submit_btn = document.getElementById('submit_btn');

  submit_btn.addEventListener('click',function(e){
    e.preventDefault();
    console.log("submit");
    var email = document.getElementById('email').value;
    var username = document.getElementById('username').value
    var password = document.getElementById('password').value;
    var conpassword = document.getElementById('conpassword').value;

    console.log(email,username,password,conpassword);
    var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
            //var address = document.getElementById[email].value;
            if (reg.test(email) == false) {
                alert('Invalid Email Address');
                return (false);
            } else{ var send_data = {
      "email": email,
      "username": username,
      "password": password
    };
  }
    if(email && username && (password==conpassword)){
      var saveData = $.ajax({
        type: 'POST',
        url: "http://localhost:63099/api/users",
        data: send_data,
        dataType: "json",
        success: function(result) {
          alert("User Created");
          window.location = "index.html";
        }
      });
    }
  });



});
