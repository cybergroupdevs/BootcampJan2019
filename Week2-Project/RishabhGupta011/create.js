$(document).ready(function(){

    $.ajax({
        url: localhost + "/api/Designations",
        type: 'GET',
        dataType:'json',
        success:function(res){
            console.log(res);   
            res.forEach(function(designation){
                $('<option value="'+designation.Id + '">'+designation.Name +'</option>').appendTo('#Designation');     
            })
        }
    })
    $(document).on('submit','#create-employee-form',function(e){
        e.preventDefault();

        var data = { 

            "FirstName" : document.getElementById('FirstName').value,
            "LastName" : document.getElementById('LastName').value,
            "Gender" : document.getElementById('Gender').checked?'Male':'Female',
            "FathersName" : document.getElementById('FathersName').value,
            "MothersName" : document.getElementById('MothersName').value,
            "CgiCode" : document.getElementById('CgiCode').value,
            "DateOfBirth" : document.getElementById('DateOfBirth').value,
            "MobileNumber" : document.getElementById('MobileNumber').value,
            "Email" : document.getElementById('Email').value,
            "DesignationId" : document.getElementById('Designation').value,
            "Department" : document.getElementById('Department').value,
            "Addresses": [
                { "HouseNo" : document.getElementById('HouseNo').value,
                 "Street" : document.getElementById('Street').value,
                 "City" : document.getElementById('City').value,
                 "State" : document.getElementById('State').value,
                 "District" : document.getElementById('District').value,
                 "Pincode" : document.getElementById('Pincode').value
                }],
            "EmployeesEducationQualifications": [

            ]
        };
        var startdates = document.getElementsByName('StartDate');
        var enddates = document.getElementsByName('EndDate');
        var university = document.getElementsByName('University');
        var marks = document.getElementsByName('Marks');

        for(var i = 0;i<4;i++)
        {
            if(startdates[i].value == "")
                continue;
            let d = {};
            d['EducationQualificationId'] = i + 1;
            d['StartDate']  = startdates[i].value;
            d['EndDate']  = enddates[i].value;
            d['University']  = university[i].value;
            d['Marks']  = marks[i].value;

            data.EmployeesEducationQualifications.push(d);
        }
        console.log(data);

        $.ajax({
            url: localhost + "/api/Employees",
            type: 'POST',
            data : data,
            dataType:'json',
            success:function(res){
                console.log(res);   
                location.href ="/list.html";
            }
        })

    })
})
