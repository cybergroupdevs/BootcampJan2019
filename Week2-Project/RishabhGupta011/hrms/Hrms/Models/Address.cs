//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Hrms.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class Address
    {
        public int Id { get; set; }
        public Nullable<int> EmployeeId { get; set; }
        public string HouseNo { get; set; }
        public string Street { get; set; }
        public string District { get; set; }
        public string City { get; set; }
        public string State { get; set; }
        public string Pincode { get; set; }
    
        public virtual Employee Employee { get; set; }
    }
}