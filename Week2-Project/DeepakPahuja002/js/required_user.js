$(document).ready(function(){

    var user_name = document.getElementById("user_name");
    var EmployeeId = document.getElementById("EmployeeId");
    var Name = document.getElementById("Name");
    var Designation = document.getElementById("Designation");
    var PhoneNo = document.getElementById("PhoneNo");
    var EmailId = document.getElementById("EmailId");
    var getUrl = function getUrl(param){
        var pageUrl = window.location.search.substring(1);
        var urlVariables = pageUrl.split("&");
        var parameterName;
        var i;
        for(i=0; i<urlVariables.length; i++){
            parameterName = urlVariables[i].split("=");
            if(parameterName[0] == param){
                return  parameterName[1] == undefined ? true : decodeURIComponent(parameterName[1]);
            }
        }
    }

    var EmpId = getUrl("id");

    $.ajax({
        type: 'GET',
        url: 'http://localhost:64061/api/Employees/' + EmpId,
        success: function(data) {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:64061/api/SignUps',
                success: function(SignUpData) {
                    
                    user_name.innerHTML = data.Name;

                    if(data.EmployeeId == null){
                        EmployeeId.value = "Null";
                    }else{ EmployeeId.value = data.EmployeeId;}


                    if(data.PhoneNo == null){
                        PhoneNo.value = "Null";
                    }else{ PhoneNo.value = data.PhoneNo;}

                    Name.value = data.Name;
                    Designation.value = data.Designation;

                    for(i=0;i<SignUpData.length;i++){
                        if(data.Name == SignUpData[i].Name){
                            EmailId.value = SignUpData[i].EmailId;
                        }
                        else{
                            EmailId.value = "Null";
                        }
                    }  
                }
            });    
        }
    });
    
    ////////////////////             UPDATE FUNCTION          ///////////////////////

    $("#update_info_btn").click(function(){
        var userdata = {
            "EmployeeId": EmployeeId.value,
            "Name": Name.value,
            "Designation": Designation.value,
            "PhoneNo": PhoneNo.value,
            "SignUpId": null
        }       
        $.ajax({
            type: 'PUT',
            url: 'http://localhost:64061/api/Employees/' + EmpId,
            data: userdata,
            success: function(data) {
                location.replace("list.html");
            }
        });
    });
    
    ////////////////////             DELETE FUNCTION          ///////////////////////

    $("#delete_user_btn").click(function(){ 
        $.ajax({
            type: 'DELETE',
            url: 'http://localhost:64061/api/Employees/' + EmpId,
            success: function(data) {                
                alert("User deleted !!");
                location.replace("list.html");
            }
        });
    });
});