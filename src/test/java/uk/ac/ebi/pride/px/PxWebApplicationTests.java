package uk.ac.ebi.pride.px;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class test the PX web application
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PxWebApplicationTests {

  @Autowired
  PxWebApplication controller;

  /**
   * Sanity check tha the application is not null when launched.
   */
  @Test
  public void contextLoads() {
    assertThat(controller).isNotNull();
  }

}
