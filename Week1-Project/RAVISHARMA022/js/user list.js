function showlist(){								
				$.ajax	({
				url: "http://localhost:50052/api/EmployeeDetail",
				type: 'GET',
				dataType: 'json', 
				success: function(data)
									{
									var table=document.getElementById("mytable");
										for (var i=0; i<data.length; i++){
											var row=table.insertRow(table.length);
											row.insertCell(0).innerHTML=data[i].Id;
											row.insertCell(1).innerHTML=data[i].firstname;
											row.insertCell(2).innerHTML=data[i].lastname;
											row.insertCell(3).innerHTML=data[i].Email;
											row.insertCell(4).innerHTML=data[i].Phone;
											row.insertCell(5).innerHTML=data[i].dob;
											row.insertCell(6).innerHTML=data[i].designation;
									}
				} 
						});
};