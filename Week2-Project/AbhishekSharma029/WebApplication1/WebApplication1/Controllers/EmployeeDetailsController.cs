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
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class EmployeeDetailsController : ApiController
    {
        private HRMSEntities3 db = new HRMSEntities3();

        // GET: api/EmployeeDetails
        public IQueryable<EmployeeDetail> GetEmployeeDetails()
        {
            return db.EmployeeDetails;
        }

        // GET: api/EmployeeDetails/5
        [ResponseType(typeof(EmployeeDetail))]
        public IHttpActionResult GetEmployeeDetail(int id)
        {
            EmployeeDetail employeeDetail = db.EmployeeDetails.Find(id);
            if (employeeDetail == null)
            {
                return NotFound();
            }

            return Ok(employeeDetail);
        }

        // PUT: api/EmployeeDetails/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutEmployeeDetail(int id, EmployeeDetail employeeDetail)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != employeeDetail.EmployeeId)
            {
                return BadRequest();
            }

            db.Entry(employeeDetail).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!EmployeeDetailExists(id))
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

        // POST: api/EmployeeDetails
        [ResponseType(typeof(EmployeeDetail))]
        public IHttpActionResult PostEmployeeDetail(EmployeeDetail employeeDetail)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.EmployeeDetails.Add(employeeDetail);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = employeeDetail.EmployeeId }, employeeDetail);
        }

        // DELETE: api/EmployeeDetails/5
        [ResponseType(typeof(EmployeeDetail))]
        public IHttpActionResult DeleteEmployeeDetail(int id)
        {
            EmployeeDetail employeeDetail = db.EmployeeDetails.Find(id);
            if (employeeDetail == null)
            {
                return NotFound();
            }

            db.EmployeeDetails.Remove(employeeDetail);
            db.SaveChanges();

            return Ok(employeeDetail);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool EmployeeDetailExists(int id)
        {
            return db.EmployeeDetails.Count(e => e.EmployeeId == id) > 0;
        }
    }
}