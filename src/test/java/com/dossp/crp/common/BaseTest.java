/**
 * @copy right Dossp Company All rights reserved
 *
 * @Title: BaseTest.java 
 *
 * @Date:  2016年12月30日  下午3:23:55
 *
 * @Package com.dossp.crp.common
 */


package com.dossp.crp.common;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yufenghui
 * </p>
 * 日期：2016年12月30日 下午3:23:55
 * </p>
 * 描述：
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/spring/spring-context.xml"})
public abstract class BaseTest {

}
