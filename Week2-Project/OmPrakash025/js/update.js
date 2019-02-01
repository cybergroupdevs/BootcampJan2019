function loadInfo(){
    var url = new URL(window.location.href);
    var id = url.searchParams.get("id");
    console.log(id);
    $.ajax({
            url: 'http://localhost:50191/api/Employees/'+Number(id),
            type: 'GET',
            dataType: 'json',
            success: function(item){
                    $("uid").val(item['ID']);
                    $('#name').val(item['Name']);
                    $('#mail').val(item['Email']); 
                    $('#phone').val(item['PhoneNumber']);
                    $('#fathers_name').val(item['FathersName']); 
                    $('#mothers_name').val(item['MothersName']); 
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
    regData = { 
            "Logins": [],
            "ID":Number(id);
            "Name": $('#name').val(), 
            "Email": $('#mail').val(), 
            "PhoneNumber": $('#mail').val(), 
            "FathersName": $('#mail').val(),  
            "MothersName": $('#mail').val(), 
            "DOB": $('#mail').val(), 
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
           url : "http://localhost:50191/api/Employees/"+Number(id),
           dataType : "json",
           data : regData,
           success : function (msg) {
               if (msg) {
                   alert("Somebody" + name + " was updated in list !");
                   location.reload(true);
               } 
               else {
                   alert("Cannot update !");
               }
           }
    });
}





