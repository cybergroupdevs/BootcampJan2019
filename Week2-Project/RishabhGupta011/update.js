
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

    var id = localStorage.getItem('current_eid') || 9;
    var employeeData;
    $.ajax({
        url: localhost + "/api/Employees/" +  id,
        type: 'GET',
        dataType:'json',
        success:function(employee){
            console.log(employee);   
            employeeData = employee;
            let address = employee.Addresses[0];
            document.getElementById('FirstName').value = employee.FirstName;
            document.getElementById('LastName').value = employee.LastName;
            document.getElementById('FathersName').value = employee.FathersName;
            document.getElementById('MothersName').value = employee.MothersName;
            document.getElementById('CgiCode').value = employee.CgiCode;
            document.getElementById('DateOfBirth').value = getCorrectDateString(employee.DateOfBirth);
            document.getElementById('MobileNumber').value = employee.MobileNumber;
            document.getElementById('Email').value = employee.Email;
            document.getElementById('Designation').value = employee.Designation.Id;
            document.getElementById('Department').value = employee.Department,
                document.getElementById('HouseNo').value = address.HouseNo;
            document.getElementById('Street').value = address.Street;
            document.getElementById('City').value = address.City;
            document.getElementById('State').value = address.State ;
            document.getElementById('District').value = address.District;
            document.getElementById('Pincode').value = address.Pincode;
            if(employee.Gender == 'Male')
                document.getElementById('Gender').checked = true;
            else
            { 
                document.getElementById('Gender').nextSibling.nextSibling.checked = true;
            }

            var employeesEducationalQualificationsId = document.getElementsByName('EmployeesEducationQualificationsId');
            var startdates = document.getElementsByName('StartDate');
            var enddates = document.getElementsByName('EndDate');
            var university = document.getElementsByName('University');
            var marks = document.getElementsByName('Marks');
            var employeeEducationQualifications = employee.EmployeesEducationQualifications;
            for(var i = 0;i<employeeEducationQualifications.length ;i++)
            {   
                employeesEducationalQualificationsId[employeeEducationQualifications[i].EducationQualification.Id - 1].value = employeeEducationQualifications[i].Id;
                startdates[employeeEducationQualifications[i].EducationQualification.Id - 1].value = getCorrectDateString(employeeEducationQualifications[i].StartDate);
                enddates[employeeEducationQualifications[i].EducationQualification.Id - 1].value = getCorrectDateString(employeeEducationQualifications[i].EndDate);
                university[employeeEducationQualifications[i].EducationQualification.Id - 1].value = employeeEducationQualifications[i].University ;
                marks[employeeEducationQualifications[i].EducationQualification.Id - 1].value = employeeEducationQualifications[i].Marks;


            }
        }
    })



    $(document).on('submit','#create-employee-form',function(e){
        e.preventDefault();
        console.log(employeeData);
        var data = { 
            "Id" : id,
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
                 "Pincode" : document.getElementById('Pincode').value,
                 "EmployeeId" : id,
                 "Id":employeeData.Addresses[0].Id
                }],
            "EmployeesEducationQualifications": [

            ]
        };
        var startdates = document.getElementsByName('StartDate');
        var enddates = document.getElementsByName('EndDate');
        var university = document.getElementsByName('University');
        var marks = document.getElementsByName('Marks');
        var employeesEducationalQualificationsId = document.getElementsByName('EmployeesEducationQualificationsId');


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
            d["EmployeeId"] =id;
            d["Id"] = employeesEducationalQualificationsId[i].value;

            data.EmployeesEducationQualifications.push(d);
        }
        console.log(data);

        $.ajax({
            url: localhost + "/api/Employees/" + id,
            type: 'PUT',
            data : data,
            dataType:'json',
            success:function(res){
                console.log("Response for Put")
                console.log(res);   
                location.href = "details.html";
            }
        })

    })
    function getCorrectDateString(datestring)
    {
        if(datestring == null)
            return null
        else
            return datestring.split('T')[0];
    }
})
