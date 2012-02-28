/**
 * 
 */
package com.demo.action;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.eontime.bdp.security.UserService;
import com.eontime.bdp.security.annotations.SecurityService;
import com.eontime.bdp.security.core.User;

/**
 * @author yuan
 * @date Feb 28, 2012
 */
@RunWith(Arquillian.class)
public class TestDao {

	// @Inject
	// @BdpMock
	// EntityManager em;
	@Inject
	@SecurityService
	UserService us;

	@Deployment(name="test")
	public static Archive<?> createTestArchive() {
		Archive<?> ar = ShrinkWrap.create(WebArchive.class, "test.war")
				.addPackages(true, "com.demo.action")
				.addPackages(true, "com.demo.domain")
				.addPackages(true, "com.eontime.bdp")
				.addPackages(true, "org.jboss.solder")
//				.addPackages(true, "org.activiti")
//				.addPackages(true, "org.apache.tools.ant")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsManifestResource("META-INF/persistence.xml", "persistence.xml");
		return ar;
	
	}

	@Test
	public void test1() {
		User user = us.getUserById("yuanqixun");
		System.out.println(user);
		// String jql = "select m from Menu";
		// TypedQuery<Menu> query = em.createQuery(jql, Menu.class);
		// List<Menu> result = query.getResultList();
		// System.out.println(result);
		// OneA a = new OneA();
		// a.setOneaId("001");
		// em.persist(a);
		// em.flush();
	}
}
