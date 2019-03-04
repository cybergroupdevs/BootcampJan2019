function loadInfo(){
    var url = new URL(window.location.href);
    var id = url.searchParams.get("id");
    id=Number(id);
    document.getElementById("uid").value=id;
    $.ajax({
            url: 'http://localhost:50191/api/Employees/'+id,
            type: 'GET',
            dataType: 'json',
            success: function(item){
                    $('#name').val(item['Name']);
                    $('#mail').val(item['Email']); 
                    $('#phone').val(item['PhoneNumber']);
                    $('#fname').val(item['FathersName']); 
                    $('#mname').val(item['MothersName']); 
                    $('#user_dob').val(item['DOB']);
                    $('#gender').val(item['Gender']);
                    $('#blood').val(item['BloodGroup']);   
                    $('#qualif').val(item['Qualification']); 
                    $('#nationality').val(item['Nationality']);
                    $('#aadhar').val(item['AadharNumber']); 
                    $('#pan').val(item['PanNumber']); 
                    $('#bio').val(item['Bio']); 
                    $('#job').val(item['JobRole']);  
        }
    });
}

function updateEmployee(){
    var url = new URL(window.location.href);
    var id = url.searchParams.get("id");
    id=Number(id);
    console.log(id);
    regData = { 
            "Logins": [],
            "ID":id,
            "Name": $('#name').val(), 
            "Email": $('#mail').val(), 
            "PhoneNumber": $('#phone').val(), 
            "FathersName": $('#fname').val(),  
            "MothersName": $('#mname').val(), 
            "DOB": $('#user_dob').val(), 
            "Gender": $('#gender').val(), 
            "BloodGroup": $('#blood').val(),    
            "Qualification": $('#qualif').val(), 
            "Nationality": $('#nationality').val(), 
            "AadharNumber": $('#aadhar').val(), 
            "PanNumber": $('#pan').val(), 
            "Bio": $('#bio').val(), 
            "JobRole": $('#job').val() 
           };
    $.ajax({
           type : "PUT",
           url : "http://localhost:50191/api/Employees/"+id,
           dataType : "json",
           data : regData,
        error:function(e){
            alert(e);
        },
           success : function (msg) {
               if (msg) {
                   window.location ="list.html";
               } 
               else { 
                   
                   alert("Cannot update !");
                   window.location ="list.html";
                   
               }
           }
    });
}





