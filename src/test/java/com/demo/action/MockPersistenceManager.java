/**
 * 
 */
package com.demo.action;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 * @author yuan
 * @date Feb 28, 2012
 */
@ApplicationScoped
public class MockPersistenceManager implements Serializable {

	/**
   * 
   */
	private static final long serialVersionUID = 1L;
	/**
   * 
   */
	@Produces
	@BdpMock
	@PersistenceUnit(unitName = "test")
	EntityManagerFactory bdpEMFactory;

	@Produces
	@Dependent
	@BdpMock
	@PersistenceContext(unitName = "test")
	EntityManager bdpEntityManager;

}
