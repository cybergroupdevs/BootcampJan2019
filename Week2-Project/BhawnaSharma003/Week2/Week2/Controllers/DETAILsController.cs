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
    public class DETAILsController : ApiController
    {
        private EmployeeDBEntities db = new EmployeeDBEntities();

        // GET: api/DETAILs
        public IQueryable<DETAIL> GetDETAILS()
        {
            return db.DETAILS;
        }

        // GET: api/DETAILs/5
        [ResponseType(typeof(DETAIL))]
        public IHttpActionResult GetDETAIL(string id)
        {
            DETAIL dETAIL = db.DETAILS.Find(id);
            if (dETAIL == null)
            {
                return NotFound();
            }

            return Ok(dETAIL);
        }

        // PUT: api/DETAILs/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutDETAIL(string id, DETAIL dETAIL)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != dETAIL.PanCardNumber)
            {
                return BadRequest();
            }

            db.Entry(dETAIL).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DETAILExists(id))
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

        // POST: api/DETAILs
        [ResponseType(typeof(DETAIL))]
        public IHttpActionResult PostDETAIL(DETAIL dETAIL)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.DETAILS.Add(dETAIL);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (DETAILExists(dETAIL.PanCardNumber))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = dETAIL.PanCardNumber }, dETAIL);
        }

        // DELETE: api/DETAILs/5
        [ResponseType(typeof(DETAIL))]
        public IHttpActionResult DeleteDETAIL(string id)
        {
            DETAIL dETAIL = db.DETAILS.Find(id);
            if (dETAIL == null)
            {
                return NotFound();
            }

            db.DETAILS.Remove(dETAIL);
            db.SaveChanges();

            return Ok(dETAIL);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool DETAILExists(string id)
        {
            return db.DETAILS.Count(e => e.PanCardNumber == id) > 0;
        }
    }
}