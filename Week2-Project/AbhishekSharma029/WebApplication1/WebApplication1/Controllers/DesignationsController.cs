﻿using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class DesignationsController : ApiController
    {
        private HRMSEntities3 db = new HRMSEntities3();

        // GET: api/Designations
        public IQueryable<Designation> GetDesignations()
        {
            return db.Designations;
        }

        // GET: api/Designations/5
        [ResponseType(typeof(Designation))]
        public IHttpActionResult GetDesignation(int id)
        {
            Designation designation = db.Designations.Find(id);
            if (designation == null)
            {
                return NotFound();
            }

            return Ok(designation);
        }

        // PUT: api/Designations/5
        [ResponseType(typeof(void))]
        public IHttpActionResult PutDesignation(int id, Designation designation)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != designation.DesignationId)
            {
                return BadRequest();
            }

            db.Entry(designation).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!DesignationExists(id))
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

        // POST: api/Designations
        [ResponseType(typeof(Designation))]
        public IHttpActionResult PostDesignation(Designation designation)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Designations.Add(designation);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = designation.DesignationId }, designation);
        }

        // DELETE: api/Designations/5
        [ResponseType(typeof(Designation))]
        public IHttpActionResult DeleteDesignation(int id)
        {
            Designation designation = db.Designations.Find(id);
            if (designation == null)
            {
                return NotFound();
            }

            db.Designations.Remove(designation);
            db.SaveChanges();

            return Ok(designation);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool DesignationExists(int id)
        {
            return db.Designations.Count(e => e.DesignationId == id) > 0;
        }
    }
}