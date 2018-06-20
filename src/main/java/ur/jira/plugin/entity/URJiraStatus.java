package ur.jira.plugin.entity;


import net.java.ao.Entity;

public interface URJiraStatus extends Entity {

    String getURStatus();

    void setURStatus(String URStatus);


    String getJiraStatus();

    void setJiraStatus(String jiraStatus);
}
