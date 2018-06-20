package ur.jira.plugin.service;

import com.atlassian.activeobjects.tx.Transactional;
import ur.jira.plugin.entity.URJiraStatus;

import java.util.List;


@Transactional
public interface URJiraStatusServiceInterface {

    URJiraStatus add(String URStatus, String jiraStatus);

    List<URJiraStatus> all();

}
