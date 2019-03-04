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
using Week2.Models;

namespace Week2.Controllers
{
    public class DESIGNATIONsController : ApiController
    {
        private EmployeeDBEntities db = new EmployeeDBEntities();

        // GET: api/DESIGNATIONs
        public IQueryable<DESIGNATION> GetDESIGNATIONs()
        {
            return db.DESIGNATIONs;
        }

        // GET: api/DESIGNATIONs/5
        [ResponseType(typeof(DESIGNATION))]
        public IHttpActionResult GetDESIGNATION(string id)
        {
            DESIGNATION dESIGNATION = db.DESIGNATIONs.Find(id);
            if (dESIGNATION == null)
            {
                return NotFound();
            }

            return Ok(dESIGNATION);
        }

        // PUT: api/DESIGNATIONs/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutDESIGNATION(string id, DESIGNATION dESIGNATION)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != dESIGNATION.DepartmentId)
            {
                return BadRequest();
            }

            db.Entry(dESIGNATION).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DESIGNATIONExists(id))
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

        // POST: api/DESIGNATIONs
        [ResponseType(typeof(DESIGNATION))]
        public IHttpActionResult PostDESIGNATION(DESIGNATION dESIGNATION)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.DESIGNATIONs.Add(dESIGNATION);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (DESIGNATIONExists(dESIGNATION.DepartmentId))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = dESIGNATION.DepartmentId }, dESIGNATION);
        }

        // DELETE: api/DESIGNATIONs/5
        [ResponseType(typeof(DESIGNATION))]
        public IHttpActionResult DeleteDESIGNATION(string id)
        {
            DESIGNATION dESIGNATION = db.DESIGNATIONs.Find(id);
            if (dESIGNATION == null)
            {
                return NotFound();
            }

            db.DESIGNATIONs.Remove(dESIGNATION);
            db.SaveChanges();

            return Ok(dESIGNATION);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool DESIGNATIONExists(string id)
        {
            return db.DESIGNATIONs.Count(e => e.DepartmentId == id) > 0;
        }
    }
}