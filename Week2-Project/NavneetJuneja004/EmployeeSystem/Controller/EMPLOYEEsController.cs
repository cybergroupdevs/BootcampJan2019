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
using EmployeeSystem.Model;

namespace EmployeeSystem.Controller
{
    public class EMPLOYEEsController : ApiController
    {
        private CorporateLedgerEntities6 db = new CorporateLedgerEntities6();

        // GET: api/EMPLOYEEs
        public IQueryable<EMPLOYEE> GetEMPLOYEEs()
        {
            return db.EMPLOYEEs;
        }

        // GET: api/EMPLOYEEs/5
        [ResponseType(typeof(EMPLOYEE))]
        public IHttpActionResult GetEMPLOYEE(string id)
        {
            EMPLOYEE eMPLOYEE = db.EMPLOYEEs.Find(id);
            if (eMPLOYEE == null)
            {
                return NotFound();
            }

            return Ok(eMPLOYEE);
        }

        // PUT: api/EMPLOYEEs/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutEMPLOYEE(string id, EMPLOYEE eMPLOYEE)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != eMPLOYEE.empid)
            {
                return BadRequest();
            }

            db.Entry(eMPLOYEE).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!EMPLOYEEExists(id))
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

        // POST: api/EMPLOYEEs
        [ResponseType(typeof(EMPLOYEE))]
        public IHttpActionResult PostEMPLOYEE(EMPLOYEE eMPLOYEE)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.EMPLOYEEs.Add(eMPLOYEE);

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateException)
            {
                if (EMPLOYEEExists(eMPLOYEE.empid))
                {
                    return Conflict();
                }
                else
                {
                    throw;
                }
            }

           
            catch (System.Data.Entity.Core.EntityCommandCompilationException ex)
            {
                Console.WriteLine(ex.InnerException);
            }
            catch (System.Data.Entity.Core.UpdateException ex)
            {
                Console.WriteLine(ex.InnerException);
            }

          

            catch (Exception ex)
            {
                Console.WriteLine(ex.InnerException);
                throw;
            }


            return CreatedAtRoute("DefaultApi", new { id = eMPLOYEE.empid }, eMPLOYEE);
        }

        // DELETE: api/EMPLOYEEs/5
        [ResponseType(typeof(EMPLOYEE))]
        public IHttpActionResult DeleteEMPLOYEE(string id)
        {
            EMPLOYEE eMPLOYEE = db.EMPLOYEEs.Find(id);
            if (eMPLOYEE == null)
            {
                return NotFound();
            }

            db.EMPLOYEEs.Remove(eMPLOYEE);
            db.SaveChanges();

            return Ok(eMPLOYEE);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool EMPLOYEEExists(string id)
        {
            return db.EMPLOYEEs.Count(e => e.empid == id) > 0;
        }
    }
}