function loggin(){
        $.ajax({
            
            url: 'http://localhost:50191/api/Logins/'+$('#uid').val(),
            type: 'GET',
            dataType: 'json',
            success: function(res){
                if(res.Password==$('#pass').val()) {
                   window.location = "dashboard.html";
                }
                else{
                    alert("Incorrect User-ID or password!!!");
                }
            }
        });   
    }