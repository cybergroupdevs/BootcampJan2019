create database Week3
create table EmployeeData (Id int,FirstName varchar(20) not null,LastName varchar(20), Age int not null, Email varchar(30) not null,Designation varchar(20) not null, Phone varchar(10) not null,Primary key(Id))
drop table EmployeeData
insert into EmployeeData values (1, 'Shruti','Bhati',22,'shrutibhati96@gmail.com','Intern','9560680989')

/*to get the list of all employees names and designation*/
create procedure ListOfEmployees
as
begin
	select FirstName,LastName,Designation from EmployeeData
end
go

/*to create a new employee*/
create procedure NewEmployee (@Id int,@FirstName varchar(20),@LastName varchar(20),@Age int, @Email varchar(30), @Designation varchar(20), @Phone varchar(10))
as
begin
	Insert into EmployeeData values (@Id,@FirstName,@LastName,@Age,@Email,@Designation,@Phone)
end
go
exec NewEmployee 2,'Pallavi','Verma',21,'palls@gmail.com','Intern','9560680987'
 
/*to update the employee specified by ID*/
create procedure UpdateData (@Id int,@FirstName varchar(20),@LastName varchar(20),@Age int, @Email varchar(30), @Designation varchar(20), @Phone varchar(10))
as
	if exists(select * from EmployeeData where Id=@Id )
		begin
			Update
			EmployeeData
			set 
			FirstName=@FirstName,
			LastName=@LastName,
			Age=@Age,
			Email=@Email,
			Designation=@Designation,
			Phone=@Phone
			where Id=@Id
		end
Go


/*to delete an employee*/
create procedure DeleteEmployee @Id int
as
	if exists(select * from EmployeeData where Id=@Id)
begin
	Delete from EmployeeData where Id=2
end 

