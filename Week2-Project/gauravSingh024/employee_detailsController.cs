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
using WebApplication4.models;

namespace WebApplication4.controller
{
    public class employee_detailsController : ApiController
    {
        private hrmsEntities db = new hrmsEntities();

        // GET: api/employee_details
        public IQueryable<employee_details> Getemployee_details()
        {
            return db.employee_details;
        }

        // GET: api/employee_details/5
        [ResponseType(typeof(employee_details))]
        public IHttpActionResult Getemployee_details(string id)
        {
            employee_details employee_details = db.employee_details.Find(id);
            if (employee_details == null)
            {
                return NotFound();
            }

            return Ok(employee_details);
        }

        // PUT: api/employee_details/5
        [ResponseType(typeof(void))]
        public IHttpActionResult Putemployee_details(string id, employee_details employee_details)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != employee_details.employee_id)
            {
                return BadRequest();
            }

            db.Entry(employee_details).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!employee_detailsExists(id))
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

        // POST: api/employee_details
        [ResponseType(typeof(employee_details))]
        public IHttpActionResult Postemployee_details(employee_details employee_details)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.employee_details.Add(employee_details);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (employee_detailsExists(employee_details.employee_id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = employee_details.employee_id }, employee_details);
        }

        // DELETE: api/employee_details/5
        [ResponseType(typeof(employee_details))]
        public IHttpActionResult Deleteemployee_details(string id)
        {
            employee_details employee_details = db.employee_details.Find(id);
            if (employee_details == null)
            {
                return NotFound();
            }

            db.employee_details.Remove(employee_details);
            db.SaveChanges();

            return Ok(employee_details);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool employee_detailsExists(string id)
        {
            return db.employee_details.Count(e => e.employee_id == id) > 0;
        }
    }
}