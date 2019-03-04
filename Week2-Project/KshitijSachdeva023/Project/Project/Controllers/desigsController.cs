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
using Project.Models;

namespace Project.Controllers
{
    public class desigsController : ApiController
    {
        private project2Entities db = new project2Entities();

        // GET: api/desigs
        public IQueryable<desig> Getdesigs()
        {
            return db.desigs;
        }

        // GET: api/desigs/5
        [ResponseType(typeof(desig))]
        public IHttpActionResult Getdesig(string id)
        {
            desig desig = db.desigs.Find(id);
            if (desig == null)
            {
                return NotFound();
            }

            return Ok(desig);
        }

        // PUT: api/desigs/5
        [ResponseType(typeof(void))]
        public IHttpActionResult Putdesig(string id, desig desig)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != desig.EmployeeId)
            {
                return BadRequest();
            }

            db.Entry(desig).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!desigExists(id))
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

        // POST: api/desigs
        [ResponseType(typeof(desig))]
        public IHttpActionResult Postdesig(desig desig)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.desigs.Add(desig);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (desigExists(desig.EmployeeId))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = desig.EmployeeId }, desig);
        }

        // DELETE: api/desigs/5
        [ResponseType(typeof(desig))]
        public IHttpActionResult Deletedesig(string id)
        {
            desig desig = db.desigs.Find(id);
            if (desig == null)
            {
                return NotFound();
            }

            db.desigs.Remove(desig);
            db.SaveChanges();

            return Ok(desig);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool desigExists(string id)
        {
            return db.desigs.Count(e => e.EmployeeId == id) > 0;
        }
    }
}