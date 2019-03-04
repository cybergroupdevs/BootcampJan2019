$(document).ready(function(){

    $.ajax({
        url: localhost + "/api/Employees",
        type: 'GET',
        dataType:'json',
        success:function(res){
            console.log(res);   
            res.forEach(function(employee){
                let degname = employee.Designation == null?'Null':employee.Designation.Name;
                let name = employee.FirstName + " " + employee.LastName;
                $('<tr><td><input type="hidden" class="EmployeeId" value="'+ employee.Id +'"><div class="profile-image"><img src="img/round_person_black_18dp.png"></div></td><td><ul type="none">'+                '<li class="employee-name">'+name+'</li><li class="employee-code">'+employee.CgiCode+'</li></ul></td><td><ul type="none">'+ 
                  '<li>Designation:'+ degname +'</li><li>Department:'+employee.Department+'</li><li>DOB:'+getCorrectDateString(employee.DateOfBirth)+'</li>'+ '</ul></td><td><ul type="none"><li>Email : '+employee.Email+'</li><li>Phone No : '+employee.MobileNumber+'</li></ul></td><td>' + 
                  '<img class="employee-edit-icon" src="img/baseline_edit_black_18dp.png"><img class="employee-delete-icon" src="img/baseline_delete_black_18dp.png"></td></tr>').appendTo('.employee-table');     
            })
        }
    })
    //<li>Reporting Manager:Manager</li>

    $(document).on('click','.employee-delete-icon',function(e){
        e.stopPropagation();
        element = $(this).parent().parent();
        let id =  element.find('.EmployeeId').val();
        $.ajax({
            url: localhost + "/api/Employees/"+id,
            type: 'DELETE',
            dataType:'json',
            success: function(res){
                element.hide(1000,function(){
                    element.remove();
                })
            }

        }) });

    $(document).on('click','.employee-edit-icon',function(e){
        e.stopPropagation();
        element = $(this).parent().parent();
        let id =  element.find('.EmployeeId').val();
        localStorage.setItem('current_eid',id);
        location.href = "update.html";
    });
    $(document).on('click','tr',function(e){
        let id = $(this).find('input').val();   
        localStorage.setItem('current_eid',id);
        location.href = "details.html";
    });
});
function getCorrectDateString(datestring)
{
    if(datestring == null)
        return null
    else
        return datestring.split('T')[0];
}
