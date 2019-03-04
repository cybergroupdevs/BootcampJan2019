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
using Cygrp.Models;

namespace Cygrp.Controller
{
    public class UsernamesController : ApiController
    {
        private CygrpEntities db = new CygrpEntities();

        // GET: api/Usernames
        public IQueryable<Username> GetUsernames()
        {
            return db.Usernames;
        }

        // GET: api/Usernames/5
        [ResponseType(typeof(Username))]
        public IHttpActionResult GetUsername(string id)
        {
            Username username = db.Usernames.Find(id);
            if (username == null)
            {
                return NotFound();
            }

            return Ok(username);
        }

        // PUT: api/Usernames/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutUsername(string id, Username username)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != username.Username1)
            {
                return BadRequest();
            }

            db.Entry(username).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!UsernameExists(id))
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

        // POST: api/Usernames
        [ResponseType(typeof(Username))]
        public IHttpActionResult PostUsername(Username username)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Usernames.Add(username);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (UsernameExists(username.Username1))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = username.Username1 }, username);
        }

        // DELETE: api/Usernames/dsadasasd
        [ResponseType(typeof(Username))]
        public IHttpActionResult DeleteUsername(string id)
        {
            Username username = db.Usernames.Find(id);
            if (username == null)
            {
                return NotFound();
            }

            db.Usernames.Remove(username);
            db.SaveChanges();

            return Ok(username);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool UsernameExists(string id)
        {
            return db.Usernames.Count(e => e.Username1 == id) > 0;
        }
    }
}