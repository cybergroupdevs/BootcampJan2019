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
    public class intern_loginController : ApiController
    {
        private hrmsEntities db = new hrmsEntities();

        // GET: api/intern_login
        public IQueryable<intern_login> Getintern_login()
        {
            return db.intern_login;
        }

        // GET: api/intern_login/5
        [ResponseType(typeof(intern_login))]
        public IHttpActionResult Getintern_login(string id)
        {
            intern_login intern_login = db.intern_login.Find(id);
            if (intern_login == null)
            {
                return NotFound();
            }

            return Ok(intern_login);
        }

        // PUT: api/intern_login/5
        [ResponseType(typeof(void))]
        public IHttpActionResult Putintern_login(string id, intern_login intern_login)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != intern_login.email)
            {
                return BadRequest();
            }

            db.Entry(intern_login).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!intern_loginExists(id))
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

        // POST: api/intern_login
        [ResponseType(typeof(intern_login))]
        public IHttpActionResult Postintern_login(intern_login intern_login)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.intern_login.Add(intern_login);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (intern_loginExists(intern_login.email))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = intern_login.email }, intern_login);
        }

        // DELETE: api/intern_login/5
        [ResponseType(typeof(intern_login))]
        public IHttpActionResult Deleteintern_login(string id)
        {
            intern_login intern_login = db.intern_login.Find(id);
            if (intern_login == null)
            {
                return NotFound();
            }

            db.intern_login.Remove(intern_login);
            db.SaveChanges();

            return Ok(intern_login);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool intern_loginExists(string id)
        {
            return db.intern_login.Count(e => e.email == id) > 0;
        }
    }
}