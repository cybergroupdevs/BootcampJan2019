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
using Hat.model;

namespace Hat.controller
{
    public class infoesController : ApiController
    {
        private DetailEntities db = new DetailEntities();

        // GET: api/infoes
        public IQueryable<info> Getinfoes()
        {
            return db.infoes;
        }

        // GET: api/infoes/5
        [ResponseType(typeof(info))]
        public IHttpActionResult Getinfo(string id)
        {
            info info = db.infoes.Find(id);
            if (info == null)
            {
                return NotFound();
            }

            return Ok(info);
        }

        // PUT: api/infoes/5
        [ResponseType(typeof(void))]
        public IHttpActionResult Putinfo(string id, info info)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != info.User_Name)
            {
                return BadRequest();
            }

            db.Entry(info).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!infoExists(id))
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

        // POST: api/infoes
        [ResponseType(typeof(info))]
        public IHttpActionResult Postinfo(info info)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.infoes.Add(info);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (infoExists(info.User_Name))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = info.User_Name }, info);
        }

        // DELETE: api/infoes/5
        [ResponseType(typeof(info))]
        public IHttpActionResult Deleteinfo(string id)
        {
            info info = db.infoes.Find(id);
            if (info == null)
            {
                return NotFound();
            }

            db.infoes.Remove(info);
            db.SaveChanges();

            return Ok(info);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool infoExists(string id)
        {
            return db.infoes.Count(e => e.User_Name == id) > 0;
        }
    }
}