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
using EmployeeSystem.Model;

namespace EmployeeSystem.Controller
{
    public class SIGNUPsController : ApiController
    {
        private CorporateLedgerEntities6 db = new CorporateLedgerEntities6();

        // GET: api/SIGNUPs
        public IQueryable<SIGNUP> GetSIGNUPs()
        {
            return db.SIGNUPs;
        }

        // GET: api/SIGNUPs/5
        [ResponseType(typeof(SIGNUP))]
        public IHttpActionResult GetSIGNUP(string id)
        {
            SIGNUP sIGNUP = db.SIGNUPs.Find(id);
            if (sIGNUP == null)
            {
                return NotFound();
            }

            return Ok(sIGNUP);
        }

        // PUT: api/SIGNUPs/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutSIGNUP(string id, SIGNUP sIGNUP)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != sIGNUP.id)
            {
                return BadRequest();
            }

            db.Entry(sIGNUP).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!SIGNUPExists(id))
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

        // POST: api/SIGNUPs
        [ResponseType(typeof(SIGNUP))]
        public IHttpActionResult PostSIGNUP(SIGNUP sIGNUP)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.SIGNUPs.Add(sIGNUP);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (SIGNUPExists(sIGNUP.id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = sIGNUP.id }, sIGNUP);
        }

        // DELETE: api/SIGNUPs/5
        [ResponseType(typeof(SIGNUP))]
        public IHttpActionResult DeleteSIGNUP(string id)
        {
            SIGNUP sIGNUP = db.SIGNUPs.Find(id);
            if (sIGNUP == null)
            {
                return NotFound();
            }

            db.SIGNUPs.Remove(sIGNUP);
            db.SaveChanges();

            return Ok(sIGNUP);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool SIGNUPExists(string id)
        {
            return db.SIGNUPs.Count(e => e.id == id) > 0;
        }
    }
}