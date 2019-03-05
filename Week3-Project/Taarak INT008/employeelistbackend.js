

function postingdetails(){

  var Name=document.getElementById('fname').value;
  var Password=document.getElementById('password').value;
 
  var emailid=document.getElementById('email').value;
  console.log(emailid);

  var PostingData={
            "name": Name,
            
            "Email":emailid,
            "password":Password



  }
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8083//register/Employee',
        data:PostingData,  
            success: function(data) {
        alert("SUBMISSION SUCCESSFUL:WELCOME ABOARD");
        location.href = "employeelist.html";
      }
    });
  }
    
function deleteDetails(){
  

var idgetting=localStorage.getItem("id");
//"id"=idgetting;

if(confirm("ARE YOU SURE?")){
    $.ajax({
    url: 'http://localhost:8083//register/Employee' + idgetting,
    type: 'DELETE',
    // data:DeletingSingleData,
    

    success: function(data) {
        alert("DATA DELETED SUCCESSFULLY");
        location.href = "employeelist.html";
    }
  
});}
    else{
      alert("im upset");
    }
}

function updatingdetails(){

  var firstname=document.getElementById('fname').value;

 
  var emailid=document.getElementById('email').value;
  
  var password=document.getElementById('password').value;
  var UpdateData={
            "fname": name,
            
            "Email":emailid,
            "password":password,
            "id":idgetting 


  }


    $.ajax({
    url: 'http://localhost:8083//register/Employee'+idgetting,
    type: 'PUT',
    data:UpdateData,
    success: function(data) {
        alert("UPDATED SUCCESSFULLY");
        location.href = "employeelist.html";
    }
});
 }