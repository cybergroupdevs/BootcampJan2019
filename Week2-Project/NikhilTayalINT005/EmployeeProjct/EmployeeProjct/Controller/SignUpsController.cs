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
using EmployeeProjct.Model;

namespace EmployeeProjct.Controller
{
    public class SignUpsController : ApiController
    {
        private EmployeesEntities db = new EmployeesEntities();

        // GET: api/SignUps
        public IQueryable<SignUp> GetSignUps()
        {
            return db.SignUps;
        }

        // GET: api/SignUps/5
        [ResponseType(typeof(SignUp))]
        public IHttpActionResult GetSignUp(int id)
        {
            SignUp signUp = db.SignUps.Find(id);
            if (signUp == null)
            {
                return NotFound();
            }

            return Ok(signUp);
        }

        // PUT: api/SignUps/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutSignUp(int id, SignUp signUp)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != signUp.Id)
            {
                return BadRequest();
            }

            db.Entry(signUp).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!SignUpExists(id))
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

        // POST: api/SignUps
        [ResponseType(typeof(SignUp))]
        public IHttpActionResult PostSignUp(SignUp signUp)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.SignUps.Add(signUp);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = signUp.Id }, signUp);
        }

        // DELETE: api/SignUps/5
        [ResponseType(typeof(SignUp))]
        public IHttpActionResult DeleteSignUp(int id)
        {
            SignUp signUp = db.SignUps.Find(id);
            if (signUp == null)
            {
                return NotFound();
            }

            db.SignUps.Remove(signUp);
            db.SaveChanges();

            return Ok(signUp);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool SignUpExists(int id)
        {
            return db.SignUps.Count(e => e.Id == id) > 0;
        }
    }
}