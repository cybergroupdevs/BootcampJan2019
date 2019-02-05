$(document).ready(function(){
    $("#LoginBtn").click(Login);
    function Login(){
        var EmailId = document.getElementById("EmailId");
        var Password = document.getElementById("Password");
        $.ajax({
            type: 'GET',
            url: 'http://localhost:64061/api/SignUps',
            success: function(data) {
                for(i=0; i<data.length;i++){
                    if(EmailId.value == data[i].EmailId){
                        if(Password.value == data[i].Password){
                            location.replace("list.html");
                        } 
                    }
                }
            }
        });
    }
})
