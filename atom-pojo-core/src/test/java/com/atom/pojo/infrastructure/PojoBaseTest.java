package com.atom.pojo.infrastructure;

import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;

/**
 * Pojo BaseTest
 */
@SpringApplicationContext("/spring-beans-unit.xml")
public abstract class PojoBaseTest extends UnitilsJUnit4 {

}
