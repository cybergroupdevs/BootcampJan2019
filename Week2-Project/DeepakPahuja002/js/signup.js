$(document).ready(function(){
    $("#SignUpBtn").click(SignUp);
    function SignUp(){
        var Name = document.getElementById("Name");
        var EmailId = document.getElementById("EmailId");
        var Password = document.getElementById("Password");
        var signUpData = {
            "Name": Name.value,
            "EmailId": EmailId.value,
            "Password": Password.value
        };
        $.ajax({
            type: 'POST',
            url: 'http://localhost:64061/api/SignUps',
            data: signUpData,
            success: function(data) {
                console.log(data);
                alert("User created !!");
                location.replace("create_user.html?id=" + data.Id);
            }
        });


    };
})