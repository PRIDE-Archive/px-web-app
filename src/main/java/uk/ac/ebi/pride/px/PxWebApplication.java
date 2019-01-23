package uk.ac.ebi.pride.px;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This class runs the ProteomeXchange static website as a Spring web application.
 *
 * @author Tobias-Ternent
 */
@SpringBootApplication
public class PxWebApplication {

  /**
   * This method launches the Spring web application.
   * @param args program arguments, which are unused
   */
  public static void main(String[] args) {
    SpringApplication.run(PxWebApplication.class, args);
  }

  /**
   * This inner class is the controller to handle errors encountered on the website.
   */
  @Controller
  public class RedirectUnknownUrls implements ErrorController {

    /**
     * This method maps the "/error" path, which redirects the user to the root home page "/".
     * @param response redirects the user to the root home page "/".
     * @throws IOException problem when redirecting user.
     */
    @GetMapping("/error")
    public void redirectNonExistentUrlsToHome(HttpServletResponse response) throws IOException {
      response.sendRedirect("/");
    }

    /**
     * Gets the error path.
     * @return the error path "/error"
     */
    @Override
    public String getErrorPath() {
      return "/error";
    }
  }

  /**
   * This inner class is the controller to redirect from the submission directory to the submission page.
   */
  @Controller
  public class SubmissionRedirection {
    /**
     * Handles the redirection to the submission.html page.
     * @return the redirection url.
     */
    @RequestMapping(value="/submission",method = RequestMethod.GET)
    public String redirectSubmissionPage(){
      return "redirect:/submission/index.html";
    }

  }

    /**
     * This inner class is the controller to redirect from the subscribe directory to the subscribe page.
     */
    @Controller
    public class SubscribeRedirection {
        /**
         * Handles the redirection to the submission.html page.
         * @return the redirection url.
         */
        @RequestMapping(value="/subscribe",method = RequestMethod.GET)
        public String redirectSubmissionPage(){
            return "redirect:/subscribe/index.html";
        }

    }

  @Controller
  public class ContactRedirection{

      @RequestMapping(value="/contact",method = RequestMethod.GET)
      public String redirectContactPage(){
          return "redirect:/contact/index.html";
      }
  }
}
