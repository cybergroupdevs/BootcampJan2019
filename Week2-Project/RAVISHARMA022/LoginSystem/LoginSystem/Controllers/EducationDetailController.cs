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
using LoginSystem.Models;

namespace LoginSystem.Controllers
{
    public class EducationDetailController : ApiController
    {
        private LoginsystemEntities db = new LoginsystemEntities();

        // GET: api/EducationDetail
        public IQueryable<EducationDetail> GetEducationDetails()
        {
            return db.EducationDetails;
        }

        // GET: api/EducationDetail/5
        [ResponseType(typeof(EducationDetail))]
        public IHttpActionResult GetEducationDetail(string id)
        {
            EducationDetail educationDetail = db.EducationDetails.Find(id);
            if (educationDetail == null)
            {
                return NotFound();
            }

            return Ok(educationDetail);
        }

        // PUT: api/EducationDetail/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutEducationDetail(string id, EducationDetail educationDetail)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != educationDetail.Id)
            {
                return BadRequest();
            }

            db.Entry(educationDetail).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!EducationDetailExists(id))
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

        // POST: api/EducationDetail
        [ResponseType(typeof(EducationDetail))]
        public IHttpActionResult PostEducationDetail(EducationDetail educationDetail)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.EducationDetails.Add(educationDetail);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (EducationDetailExists(educationDetail.Id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = educationDetail.Id }, educationDetail);
        }

        // DELETE: api/EducationDetail/5
        [ResponseType(typeof(EducationDetail))]
        public IHttpActionResult DeleteEducationDetail(string id)
        {
            EducationDetail educationDetail = db.EducationDetails.Find(id);
            if (educationDetail == null)
            {
                return NotFound();
            }

            db.EducationDetails.Remove(educationDetail);
            db.SaveChanges();

            return Ok(educationDetail);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool EducationDetailExists(string id)
        {
            return db.EducationDetails.Count(e => e.Id == id) > 0;
        }
    }
}