using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using weekTwo.model;

namespace weekTwo.controllers
{
    public class employeesController : ApiController
    {
        private weekTwoEntities db = new weekTwoEntities();

        // GET: api/employees
        public IQueryable<employee> Getemployees()
        {
            return db.employees;
        }

        // GET: api/employees/5
        [ResponseType(typeof(employee))]
        public IHttpActionResult Getemployee(string id)
        {
            employee employee = db.employees.Find(id);
            if (employee == null)
            {
                return NotFound();
            }

            return Ok(employee);
        }

        // PUT: api/employees/5
        [ResponseType(typeof(void))]
        public IHttpActionResult Putemployee(string id, employee employee)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != employee.employeeNo)
            {
                return BadRequest();
            }

            db.Entry(employee).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!employeeExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST: api/employees
        [ResponseType(typeof(employee))]
        public IHttpActionResult Postemployee(employee employee)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.employees.Add(employee);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (employeeExists(employee.employeeNo))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = employee.employeeNo }, employee);
        }

        // DELETE: api/employees/5
        [ResponseType(typeof(employee))]
        public IHttpActionResult Deleteemployee(string id)
        {
            employee employee = db.employees.Find(id);
            if (employee == null)
            {
                return NotFound();
            }

            db.employees.Remove(employee);
            db.SaveChanges();

            return Ok(employee);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool employeeExists(string id)
        {
            return db.employees.Count(e => e.employeeNo == id) > 0;
        }
    }
}