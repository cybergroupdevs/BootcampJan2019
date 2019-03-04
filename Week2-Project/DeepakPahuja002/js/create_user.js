$(document).ready(function(){
    $("#createNewUser").click(createNewUser);
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
    var SignUpId = getUrl("id");
    function createNewUser(){
        var EmployeeId = document.getElementById("EmployeeId");
        var Name = document.getElementById("Name");
        var Designation = document.getElementById("Designation");
        var PhoneNo = document.getElementById("PhoneNo");
        var EmailId = document.getElementById("EmailId");
        var userdata =  {    
            "EmployeeId": EmployeeId.value,
            "Name": Name.value,
            "Designation": Designation.value,
            "PhoneNo": PhoneNo.value,
            "SignUpId": SignUpId
        };
        $.ajax({
            type: 'POST',
            url: 'http://localhost:64061/api/Employees',
            data: userdata,
            success: function(data) {
                alert("User Created !!");
                location.replace("list.html");
            }
        })
    }; 
})
