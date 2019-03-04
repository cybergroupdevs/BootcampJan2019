$(document).ready(function(){

    var id = localStorage.getItem('current_eid') || 9;
    $.ajax({
        url: localhost + "/api/Employees/" + id,
        type: 'GET',
        dataType:'json',
        success:function(res){
            console.log(res);   
            let degname = res.Designation == null?'Null':res.Designation.Name;

            document.getElementById('Name').innerHTML = res.FirstName + " " + res.LastName;
            document.getElementById('Gender').innerHTML = res.Gender;
            document.getElementById('FathersName').innerHTML = res.FathersName;
            document.getElementById('MothersName').innerHTML = res.MothersName;
            document.getElementById('CgiCode').innerHTML = res.CgiCode;
            document.getElementById('DateOfBirth').innerHTML = getCorrectDateString(res.DateOfBirth);
            document.getElementById('MobileNumber').innerHTML = res.MobileNumber;
            document.getElementById('Email').innerHTML = res.Email;
            document.getElementById('Designation').innerHTML = degname;
            document.getElementById('Department').innerHTML = res.Department;

            document.getElementById('HouseNo').innerHTML = res.Addresses[0].HouseNo;
            document.getElementById('Street').innerHTML = res.Addresses[0].Street;
            document.getElementById('City').innerHTML = res.Addresses[0].City;
            document.getElementById('State').innerHTML = res.Addresses[0].State;
            document.getElementById('District').innerHTML = res.Addresses[0].District;
            document.getElementById('Pincode').innerHTML = res.Addresses[0].Pincode;
            res["EmployeesEducationQualifications"].forEach(function(edetail){
                $('<tr><td>'+edetail.EducationQualification.DegreeName+'</td><td>'+ getCorrectDateString(edetail.StartDate)+'</td><td>'+ getCorrectDateString(edetail.EndDate)+'</td><td>'+edetail.University+'</td><td>'+edetail.Marks+'</td></tr>').appendTo('#education-details-table');

            });
        }
    });

    function getCorrectDateString(datestring)
    {
        if(datestring == null)
            return null
        else
            return datestring.split('T')[0];
    }
});
