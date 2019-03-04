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
using EmployeeProjct.Model;

namespace EmployeeProjct.Controller
{
    public class EmployeeDatasController : ApiController
    {
        private EmployeesEntities db = new EmployeesEntities();

        // GET: api/EmployeeDatas
        public IQueryable<EmployeeData> GetEmployeeDatas()
        {
            return db.EmployeeDatas;
        }

        // GET: api/EmployeeDatas/5
        [ResponseType(typeof(EmployeeData))]
        public IHttpActionResult GetEmployeeData(string id)
        {
            EmployeeData employeeData = db.EmployeeDatas.Find(id);
            if (employeeData == null)
            {
                return NotFound();
            }

            return Ok(employeeData);
        }

        // PUT: api/EmployeeDatas/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutEmployeeData(string id, EmployeeData employeeData)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != employeeData.IdNumber)
            {
                return BadRequest();
            }

            db.Entry(employeeData).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!EmployeeDataExists(id))
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

        // POST: api/EmployeeDatas
        [ResponseType(typeof(EmployeeData))]
        public IHttpActionResult PostEmployeeData(EmployeeData employeeData)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.EmployeeDatas.Add(employeeData);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (EmployeeDataExists(employeeData.IdNumber))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = employeeData.IdNumber }, employeeData);
        }

        // DELETE: api/EmployeeDatas/5
        [ResponseType(typeof(EmployeeData))]
        public IHttpActionResult DeleteEmployeeData(string id)
        {
            EmployeeData employeeData = db.EmployeeDatas.Find(id);
            if (employeeData == null)
            {
                return NotFound();
            }

            db.EmployeeDatas.Remove(employeeData);
            db.SaveChanges();

            return Ok(employeeData);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool EmployeeDataExists(string id)
        {
            return db.EmployeeDatas.Count(e => e.IdNumber == id) > 0;
        }
    }
}