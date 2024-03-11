/**
 * 
 */
/**
 * 
 */
module ExemplosVendasMod35 {
	
	
	requires java.desktop;
	requires java.xml;
	requires jdk.compiler;
	requires jdk.javadoc;
	requires junit;
	requires java.persistence;
	requires org.hibernate.orm.core;
	exports br.com.rpires.domain.jpa;
	opens br.com.rpires.domain.jpa to org.hibernate.orm.core;
	
	
}