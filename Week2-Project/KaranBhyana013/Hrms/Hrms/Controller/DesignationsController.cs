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
using Hrms.Model;

namespace Hrms.Controller
{
    public class DesignationsController : ApiController
    {
        private Week1projectEntities db = new Week1projectEntities();

        // GET: api/Designations
        public IQueryable<Designation> GetDesignations()
        {
            return db.Designations;
        }

        // GET: api/Designations/5
        [ResponseType(typeof(Designation))]
        public IHttpActionResult GetDesignation(int id)
        {
            Designation designation = db.Designations.Find(id);
            if (designation == null)
            {
                return NotFound();
            }

            return Ok(designation);
        }

        // PUT: api/Designations/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutDesignation(int id, Designation designation)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != designation.Id)
            {
                return BadRequest();
            }

            db.Entry(designation).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DesignationExists(id))
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

        // POST: api/Designations
        [ResponseType(typeof(Designation))]
        public IHttpActionResult PostDesignation(Designation designation)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Designations.Add(designation);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = designation.Id }, designation);
        }

        // DELETE: api/Designations/5
        [ResponseType(typeof(Designation))]
        public IHttpActionResult DeleteDesignation(int id)
        {
            Designation designation = db.Designations.Find(id);
            if (designation == null)
            {
                return NotFound();
            }

            db.Designations.Remove(designation);
            db.SaveChanges();

            return Ok(designation);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool DesignationExists(int id)
        {
            return db.Designations.Count(e => e.Id == id) > 0;
        }
    }
}