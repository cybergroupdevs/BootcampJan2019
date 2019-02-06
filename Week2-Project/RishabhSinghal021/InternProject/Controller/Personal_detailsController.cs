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
    public class Personal_detailsController : ApiController
    {
        private ProjectEntities1 db = new ProjectEntities1();

        // GET: api/Personal_details
        public IQueryable<Personal_details> GetPersonal_details()
        {
            return db.Personal_details;
        }

        // GET: api/Personal_details/5
        [ResponseType(typeof(Personal_details))]
        public IHttpActionResult GetPersonal_details(string id)
        {
            Personal_details personal_details = db.Personal_details.Find(id);
            if (personal_details == null)
            {
                return NotFound();
            }

            return Ok(personal_details);
        }

        // PUT: api/Personal_details/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutPersonal_details(string id, Personal_details personal_details)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != personal_details.Id)
            {
                return BadRequest();
            }

            db.Entry(personal_details).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!Personal_detailsExists(id))
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

        // POST: api/Personal_details
        [ResponseType(typeof(Personal_details))]
        public IHttpActionResult PostPersonal_details(Personal_details personal_details)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Personal_details.Add(personal_details);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (Personal_detailsExists(personal_details.Id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = personal_details.Id }, personal_details);
        }

        // DELETE: api/Personal_details/5
        [ResponseType(typeof(Personal_details))]
        public IHttpActionResult DeletePersonal_details(string id)
        {
            Personal_details personal_details = db.Personal_details.Find(id);
            if (personal_details == null)
            {
                return NotFound();
            }

            db.Personal_details.Remove(personal_details);
            db.SaveChanges();

            return Ok(personal_details);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool Personal_detailsExists(string id)
        {
            return db.Personal_details.Count(e => e.Id == id) > 0;
        }
    }
}