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
    public class intern_detailsController : ApiController
    {
        private hrmsEntities db = new hrmsEntities();

        // GET: api/intern_details
        public IQueryable<intern_details> Getintern_details()
        {
            return db.intern_details;
        }

        // GET: api/intern_details/5
        [ResponseType(typeof(intern_details))]
        public IHttpActionResult Getintern_details(string id)
        {
            intern_details intern_details = db.intern_details.Find(id);
            if (intern_details == null)
            {
                return NotFound();
            }

            return Ok(intern_details);
        }

        // PUT: api/intern_details/5
        [ResponseType(typeof(void))]
        public IHttpActionResult Putintern_details(string id, intern_details intern_details)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != intern_details.intern_id)
            {
                return BadRequest();
            }

            db.Entry(intern_details).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!intern_detailsExists(id))
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

        // POST: api/intern_details
        [ResponseType(typeof(intern_details))]
        public IHttpActionResult Postintern_details(intern_details intern_details)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.intern_details.Add(intern_details);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (intern_detailsExists(intern_details.intern_id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = intern_details.intern_id }, intern_details);
        }

        // DELETE: api/intern_details/5
        [ResponseType(typeof(intern_details))]
        public IHttpActionResult Deleteintern_details(string id)
        {
            intern_details intern_details = db.intern_details.Find(id);
            if (intern_details == null)
            {
                return NotFound();
            }

            db.intern_details.Remove(intern_details);
            db.SaveChanges();

            return Ok(intern_details);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool intern_detailsExists(string id)
        {
            return db.intern_details.Count(e => e.intern_id == id) > 0;
        }
    }
}