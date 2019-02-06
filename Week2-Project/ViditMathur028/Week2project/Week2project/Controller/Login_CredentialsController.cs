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
using Week2project.Model;

namespace Week2project.Controller
{
    public class Login_CredentialsController : ApiController
    {
        private CorporateEntities5 db = new CorporateEntities5();

        // GET: api/Login_Credentials
        public IQueryable<Login_Credentials> GetLogin_Credentials()
        {
            return db.Login_Credentials;
        }

        // GET: api/Login_Credentials/5
        [ResponseType(typeof(Login_Credentials))]
        public IHttpActionResult GetLogin_Credentials(int id)
        {
            Login_Credentials login_Credentials = db.Login_Credentials.Find(id);
            if (login_Credentials == null)
            {
                return NotFound();
            }

            return Ok(login_Credentials);
        }

        // PUT: api/Login_Credentials/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutLogin_Credentials(int id, Login_Credentials login_Credentials)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != login_Credentials.Id)
            {
                return BadRequest();
            }

            db.Entry(login_Credentials).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!Login_CredentialsExists(id))
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

        // POST: api/Login_Credentials
        [ResponseType(typeof(Login_Credentials))]
        public IHttpActionResult PostLogin_Credentials(Login_Credentials login_Credentials)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Login_Credentials.Add(login_Credentials);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (Login_CredentialsExists(login_Credentials.Id))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = login_Credentials.Id }, login_Credentials);
        }

        // DELETE: api/Login_Credentials/5
        [ResponseType(typeof(Login_Credentials))]
        public IHttpActionResult DeleteLogin_Credentials(int id)
        {
            Login_Credentials login_Credentials = db.Login_Credentials.Find(id);
            if (login_Credentials == null)
            {
                return NotFound();
            }

            db.Login_Credentials.Remove(login_Credentials);
            db.SaveChanges();

            return Ok(login_Credentials);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool Login_CredentialsExists(int id)
        {
            return db.Login_Credentials.Count(e => e.Id == id) > 0;
        }
    }
}