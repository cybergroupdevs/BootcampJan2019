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
    public class AuthenticateUserController : ApiController
    {
        private LoginsystemEntities db = new LoginsystemEntities();

        // GET: api/AuthenticateUser
        public IQueryable<AuthenticateUser> GetAuthenticateUsers()
        {
            return db.AuthenticateUsers;
        }

        // GET: api/AuthenticateUser/5
        [ResponseType(typeof(AuthenticateUser))]
        public IHttpActionResult GetAuthenticateUser(string id)
        {
            AuthenticateUser authenticateUser = db.AuthenticateUsers.Find(id);
            if (authenticateUser == null)
            {
                return NotFound();
            }

            return Ok(authenticateUser);
        }

        // PUT: api/AuthenticateUser/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutAuthenticateUser(string id, AuthenticateUser authenticateUser)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != authenticateUser.Id)
            {
                return BadRequest();
            }

            db.Entry(authenticateUser).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!AuthenticateUserExists(id))
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

        // POST: api/AuthenticateUser
        [ResponseType(typeof(AuthenticateUser))]
        public IHttpActionResult PostAuthenticateUser(AuthenticateUser authenticateUser)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.AuthenticateUsers.Add(authenticateUser);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (AuthenticateUserExists(authenticateUser.Id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = authenticateUser.Id }, authenticateUser);
        }

        // DELETE: api/AuthenticateUser/5
        [ResponseType(typeof(AuthenticateUser))]
        public IHttpActionResult DeleteAuthenticateUser(string id)
        {
            AuthenticateUser authenticateUser = db.AuthenticateUsers.Find(id);
            if (authenticateUser == null)
            {
                return NotFound();
            }

            db.AuthenticateUsers.Remove(authenticateUser);
            db.SaveChanges();

            return Ok(authenticateUser);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool AuthenticateUserExists(string id)
        {
            return db.AuthenticateUsers.Count(e => e.Id == id) > 0;
        }
    }
}