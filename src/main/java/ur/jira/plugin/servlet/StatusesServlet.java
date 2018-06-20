package ur.jira.plugin.servlet;

import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import ur.jira.plugin.entity.URJiraStatus;
import ur.jira.plugin.service.URJiraStatusService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.google.common.base.Preconditions.*;

public class StatusesServlet extends HttpServlet {

    private final URJiraStatusService urJiraStatusService;

    public StatusesServlet(URJiraStatusService urJiraStatusService) {
        this.urJiraStatusService = checkNotNull(urJiraStatusService);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        final PrintWriter w = res.getWriter();
        w.write("<h1>Todos</h1>");

        // the form to post more TODOs
        w.write("<form method=\"post\">");
        w.write("<input type=\"text\" name=\"task\" size=\"25\"/>");
        w.write("  ");
        w.write("<input type=\"submit\" name=\"submit\" value=\"Add\"/>");
        w.write("</form>");

        w.write("<ol>");

        for (URJiraStatus urJiraStatus : urJiraStatusService.all()) // (2)
        {
            w.print("<li>" + urJiraStatus.getJiraStatus() + " - " + urJiraStatus.getURStatus() + "</li>");
        }

        w.write("</ol>");

        w.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        final String urStatus = req.getParameter("urStatus");
        final String jiraStatus = req.getParameter("jiraStatus");
        urJiraStatusService.add(urStatus, jiraStatus);
        res.sendRedirect(req.getContextPath() + "/plugins/servlet/statusesservice");
    }
}