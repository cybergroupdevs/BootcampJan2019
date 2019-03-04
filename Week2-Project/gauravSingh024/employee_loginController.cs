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
    public class employee_loginController : ApiController
    {
        private hrmsEntities db = new hrmsEntities();

        // GET: api/employee_login
        public IQueryable<employee_login> Getemployee_login()
        {
            return db.employee_login;
        }

        // GET: api/employee_login/5
        [ResponseType(typeof(employee_login))]
        public IHttpActionResult Getemployee_login(string id)
        {
            employee_login employee_login = db.employee_login.Find(id);
            if (employee_login == null)
            {
                return NotFound();
            }

            return Ok(employee_login);
        }

        // PUT: api/employee_login/5
        [ResponseType(typeof(void))]
        public IHttpActionResult Putemployee_login(string id, employee_login employee_login)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != employee_login.email)
            {
                return BadRequest();
            }

            db.Entry(employee_login).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!employee_loginExists(id))
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

        // POST: api/employee_login
        [ResponseType(typeof(employee_login))]
        public IHttpActionResult Postemployee_login(employee_login employee_login)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.employee_login.Add(employee_login);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (employee_loginExists(employee_login.email))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = employee_login.email }, employee_login);
        }

        // DELETE: api/employee_login/5
        [ResponseType(typeof(employee_login))]
        public IHttpActionResult Deleteemployee_login(string id)
        {
            employee_login employee_login = db.employee_login.Find(id);
            if (employee_login == null)
            {
                return NotFound();
            }

            db.employee_login.Remove(employee_login);
            db.SaveChanges();

            return Ok(employee_login);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool employee_loginExists(string id)
        {
            return db.employee_login.Count(e => e.email == id) > 0;
        }
    }
}