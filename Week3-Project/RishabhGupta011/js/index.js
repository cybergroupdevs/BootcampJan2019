$(document).on('click','.edit-btn',function()
{
var id = $(this).parent().prev().val();
localStorage.setItem('selected-project-id',id);
localStorage.setItem('selected-project-name',$(this).parent().prev().prev().html());
$('#edit-project-name').val(localStorage.getItem('selected-project-name'));
$('#edit-project-modal').modal();


});

$(document).on('click','.del-btn',function()
{  var id = $(this).parent().prev().prev().val();
    localStorage.setItem('selected-project-id',id);
    $('#delete-project-modal').modal();
});

$(document).ready(function(){
    // console.log(window.location.pathname);

    if(!localStorage.getItem('userid') && window.location.pathname == '/dashboard.html')
    {
        location.href = "/login.html";
    }
    if(window.location.pathname == '/dashboard.html')
    {
        $('#user-name').text(localStorage.getItem('username'));
    
    var userId = localStorage.getItem('userid');
$.ajax({
    url : "http://localhost:8080/v1/users/" + userId  + "/projects",
    success: function(data){
        console.log(data);
        data.forEach( (element,index) => {
            $('<tr><td>' + Number(index+1) + '</td><td>' + element.name + '</td><input type="hidden" value="'+ element.id + '"><td><img class="edit-btn" src="icon/edit-2.svg"></td><td><img class="del-btn" src="icon/trash-2.svg"></td></tr>').appendTo('tbody');
        });
       
    }
})

    }


function showAlert(status,message)
{
    type = status == 1?'success':'danger';
$('#my-alert').find('span').eq(0).text(message);
$('#my-alert').addClass('alert-'+type).addClass('show');

}
function hideAlert(sec=2000)
{
    setTimeout(function(){
        $('#my-alert').removeClass('alert-*').removeClass('show');
        location.reload();
    },sec)
}

$('#create-project-btn').click(function(){
console.log('in create');
console.log( $('#create-project-name').val())
var userId = localStorage.getItem('userid');
$.ajax({
    url : "http://localhost:8080/v1/users/" + userId + "/projects",
    method:'POST',
    contentType: "application/json",
    data: JSON.stringify({ name : $('#create-project-name').val() }), 
    success: function(data){
        console.log(data); 
        $('#create-project-modal').modal('toggle');
        showAlert(data.status,data.message);
        hideAlert();
              
    }
})

});


$('#edit-project-btn').click(function(){
    console.log('in edit');
    var projectId = localStorage.getItem('selected-project-id');   
    var userId = localStorage.getItem('userid');
    $.ajax({
        url : "http://localhost:8080/v1/users/"+userId+"/projects",
        method:'PUT',
        contentType: "application/json",
        data: JSON.stringify({ id: projectId ,name : $('#edit-project-name').val() }), 
        success: function(data){
            console.log(data); 
            $('#edit-project-modal').modal('toggle');
            showAlert(data.status,data.message);
            hideAlert();
            
                  
        }
    })
    
    });

    $('#delete-project-btn').click(function(){
        console.log('in delete');
        var projectId = localStorage.getItem('selected-project-id');  
        var userId = localStorage.getItem('userid'); 
        
        $.ajax({
            url : "http://localhost:8080/v1/users/"+userId+"/projects/" + projectId,
            method:'DELETE',
            success: function(data){
                console.log(data); 
                $('#delete-project-modal').modal('toggle');
                showAlert(data.status,data.message);
                hideAlert();
                
                      
            }
        })
        
        });

        $('#signup-btn').click(function()
        {
 console.log('in signup');
            $.ajax({
                url : "http://localhost:8080/v1/signup",
                method:'POST',
                contentType: "application/json",
                data: JSON.stringify({ username : $('#username').val().toLowerCase(),password : $('#password').val() }), 
                success: function(data){
                    console.log(data); 
                    showAlert(data.status,data.message);
                    hideAlert();
                          
                }
            })

        });

        $('#login-btn').click(function()
        {
 console.log('in login');
            $.ajax({
                url : "http://localhost:8080/v1/login",
                method:'POST',
                contentType: "application/json",
                data: JSON.stringify({ username : $('#username').val().toLowerCase(),password : $('#password').val() }), 
                success: function(data){
                    console.log(data); 
                    showAlert(data.status,data.message);
                    if(data.status == 1)
                    {
                        localStorage.setItem('userid',data.userid);
                        localStorage.setItem('username',data.username);
                        location.href="/dashboard.html";
                    }
                          
                }
            })

        });


        $('#logout-btn').click(function(){
            console.log('logout');
            var userId = localStorage.getItem('userid');   
            localStorage.removeItem('userid');
            localStorage.removeItem('username');
            $.ajax({
                url : "http://localhost:8080/v1/users/" + userId ,
                method:'DELETE',
                success: function(data){
                  location.href = "/login.html";                    
                          
                }
            })
            
            });

});

