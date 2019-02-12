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
using CorporateLedger.Models;

namespace CorporateLedger.Controllers
{
    public class loginusersController : ApiController
    {
        private CorporateLedgerEntities db = new CorporateLedgerEntities();

        // GET: api/loginusers
        public IQueryable<loginuser> Getloginusers()
        {
            return db.loginusers;
        }

        // GET: api/loginusers/5
        [ResponseType(typeof(loginuser))]
        public IHttpActionResult Getloginuser(string id)
        {
            loginuser loginuser = db.loginusers.Find(id);
            if (loginuser == null)
            {
                return NotFound();
            }

            return Ok(loginuser);
        }

        // PUT: api/loginusers/5
        [ResponseType(typeof(void))]
        public IHttpActionResult Putloginuser(string id, loginuser loginuser)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != loginuser.mail)
            {
                return BadRequest();
            }

            db.Entry(loginuser).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!loginuserExists(id))
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

        // POST: api/loginusers
        [ResponseType(typeof(loginuser))]
        public IHttpActionResult Postloginuser(loginuser loginuser)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.loginusers.Add(loginuser);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (loginuserExists(loginuser.mail))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = loginuser.mail }, loginuser);
        }

        // DELETE: api/loginusers/5
        [ResponseType(typeof(loginuser))]
        public IHttpActionResult Deleteloginuser(string id)
        {
            loginuser loginuser = db.loginusers.Find(id);
            if (loginuser == null)
            {
                return NotFound();
            }

            db.loginusers.Remove(loginuser);
            db.SaveChanges();

            return Ok(loginuser);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool loginuserExists(string id)
        {
            return db.loginusers.Count(e => e.mail == id) > 0;
        }
    }
}