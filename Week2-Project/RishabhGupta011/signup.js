$(document).ready(function(){
    $('#register-form').on('submit',function(e){

        var data = {    
            "Name" : document.getElementById('Name').value,
            "EmailId" : document.getElementById('Email').value,
            "Password" : document.getElementById('Password').value
        };
        e.preventDefault();

        if(document.getElementById('ConfirmPassword').value != data.Password)
        {
            alert('Password and Confirm Password does not match');
            return;
        }
        console.log(data.Email);
        $.ajax({
            url: localhost + "/api/Users",
            type: 'POST',
            data : data,
            dataType:'json',
            success:function(res){
                console.log(res);   
                location.href ="/create.html";
            }
        })

    })
})
