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
using CyberWeek2.Models;

namespace CyberWeek2.Controllers
{
    public class CyberEmployeesController : ApiController
    {
        private CybergroupEntities2 db = new CybergroupEntities2();

        // GET: api/CyberEmployees
        public IQueryable<CyberEmployee> GetCyberEmployees()
        {
            return db.CyberEmployees;
        }

        // GET: api/CyberEmployees/5
        [ResponseType(typeof(CyberEmployee))]
        public IHttpActionResult GetCyberEmployee(int id)
        {
            CyberEmployee cyberEmployee = db.CyberEmployees.Find(id);
            if (cyberEmployee == null)
            {
                return NotFound();
            }

            return Ok(cyberEmployee);
        }

        // PUT: api/CyberEmployees/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutCyberEmployee(int id, CyberEmployee cyberEmployee)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != cyberEmployee.ID)
            {
                return BadRequest();
            }

            db.Entry(cyberEmployee).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!CyberEmployeeExists(id))
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

        // POST: api/CyberEmployees
        [ResponseType(typeof(CyberEmployee))]
        public IHttpActionResult PostCyberEmployee(CyberEmployee cyberEmployee)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.CyberEmployees.Add(cyberEmployee);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (CyberEmployeeExists(cyberEmployee.ID))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

            return CreatedAtRoute("DefaultApi", new { id = cyberEmployee.ID }, cyberEmployee);
        }

        // DELETE: api/CyberEmployees/5
        [ResponseType(typeof(CyberEmployee))]
        public IHttpActionResult DeleteCyberEmployee(int id)
        {
            CyberEmployee cyberEmployee = db.CyberEmployees.Find(id);
            if (cyberEmployee == null)
            {
                return NotFound();
            }

            db.CyberEmployees.Remove(cyberEmployee);
            db.SaveChanges();

            return Ok(cyberEmployee);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool CyberEmployeeExists(int id)
        {
            return db.CyberEmployees.Count(e => e.ID == id) > 0;
        }
    }
}