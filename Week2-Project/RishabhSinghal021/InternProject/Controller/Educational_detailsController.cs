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
using InternProject.Model;

namespace InternProject.Controller
{
    public class Educational_detailsController : ApiController
    {
        private ProjectEntities1 db = new ProjectEntities1();

        // GET: api/Educational_details
        public IQueryable<Educational_details> GetEducational_details()
        {
            return db.Educational_details;
        }

        // GET: api/Educational_details/5
        [ResponseType(typeof(Educational_details))]
        public IHttpActionResult GetEducational_details(string id)
        {
            Educational_details educational_details = db.Educational_details.Find(id);
            if (educational_details == null)
            {
                return NotFound();
            }

            return Ok(educational_details);
        }

        // PUT: api/Educational_details/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutEducational_details(string id, Educational_details educational_details)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != educational_details.Id)
            {
                return BadRequest();
            }

            db.Entry(educational_details).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!Educational_detailsExists(id))
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

        // POST: api/Educational_details
        [ResponseType(typeof(Educational_details))]
        public IHttpActionResult PostEducational_details(Educational_details educational_details)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Educational_details.Add(educational_details);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (Educational_detailsExists(educational_details.Id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = educational_details.Id }, educational_details);
        }

        // DELETE: api/Educational_details/5
        [ResponseType(typeof(Educational_details))]
        public IHttpActionResult DeleteEducational_details(string id)
        {
            Educational_details educational_details = db.Educational_details.Find(id);
            if (educational_details == null)
            {
                return NotFound();
            }

            db.Educational_details.Remove(educational_details);
            db.SaveChanges();

            return Ok(educational_details);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool Educational_detailsExists(string id)
        {
            return db.Educational_details.Count(e => e.Id == id) > 0;
        }
    }
}