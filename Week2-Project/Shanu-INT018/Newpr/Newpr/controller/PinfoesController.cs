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
using Newpr.Model;

namespace Newpr.controller
{
    public class PinfoesController : ApiController
    {
        private hrms1Entities db = new hrms1Entities();

        // GET: api/Pinfoes
        public IQueryable<Pinfo> GetPinfoes()
        {
            return db.Pinfoes;
        }

        // GET: api/Pinfoes/5
        [ResponseType(typeof(Pinfo))]
        public IHttpActionResult GetPinfo(string id)
        {
            Pinfo pinfo = db.Pinfoes.Find(id);
            if (pinfo == null)
            {
                return NotFound();
            }

            return Ok(pinfo);
        }

        // PUT: api/Pinfoes/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutPinfo(string id, Pinfo pinfo)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != pinfo.Eid)
                {
                    return BadRequest();
                }

                db.Entry(pinfo).State = EntityState.Modified;

            
           
            try
            {
               
                db.SaveChanges();
            }
            
            catch (DbUpdateConcurrencyException)
            {
                if (!PinfoExists(id))
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

        // POST: api/Pinfoes
        [ResponseType(typeof(Pinfo))]
        public IHttpActionResult PostPinfo(Pinfo pinfo)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Pinfoes.Add(pinfo);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (PinfoExists(pinfo.Eid))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = pinfo.Eid }, pinfo);
        }

        // DELETE: api/Pinfoes/5
        [ResponseType(typeof(Pinfo))]
        public IHttpActionResult DeletePinfo(string id)
        {
            Pinfo pinfo = db.Pinfoes.Find(id);
            if (pinfo == null)
            {
                return NotFound();
            }

            db.Pinfoes.Remove(pinfo);
            db.SaveChanges();

            return Ok(pinfo);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool PinfoExists(string id)
        {
            return db.Pinfoes.Count(e => e.Eid == id) > 0;
        }
    }
}