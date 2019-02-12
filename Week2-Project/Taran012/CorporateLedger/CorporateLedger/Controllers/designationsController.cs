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
using CorporateLedger.Models;
using System.Web.Http.Cors;

namespace CorporateLedger.Controllers
{
    public class designationsController : ApiController
    {
        private CorporateLedgerEntities db = new CorporateLedgerEntities();

        // GET: api/designations
        public IQueryable<designation> Getdesignations()
        {
            return db.designations;
        }

        // GET: api/designations/5
        [ResponseType(typeof(designation))]
        public IHttpActionResult Getdesignation(int id)
        {
            designation designation = db.designations.Find(id);
            if (designation == null)
            {
                return NotFound();
            }

            return Ok(designation);
        }

        // PUT: api/designations/5
        [ResponseType(typeof(void))]
        public IHttpActionResult Putdesignation(int id, designation designation)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != designation.id)
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
                if (!designationExists(id))
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

        // POST: api/designations
        [ResponseType(typeof(designation))]
        public IHttpActionResult Postdesignation(designation designation)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.designations.Add(designation);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = designation.id }, designation);
        }

        // DELETE: api/designations/5
        [ResponseType(typeof(designation))]
        public IHttpActionResult Deletedesignation(int id)
        {
            designation designation = db.designations.Find(id);
            if (designation == null)
            {
                return NotFound();
            }

            db.designations.Remove(designation);
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

        private bool designationExists(int id)
        {
            return db.designations.Count(e => e.id == id) > 0;
        }
    }
}