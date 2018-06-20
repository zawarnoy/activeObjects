package ur.jira.plugin.service;

import com.atlassian.activeobjects.external.ActiveObjects;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.collect.Lists.newArrayList;

import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import ur.jira.plugin.entity.URJiraStatus;

import javax.inject.Inject;
import javax.inject.Named;

    @Scanned
    @Named
    public class URJiraStatusService implements URJiraStatusServiceInterface
    {
        @ComponentImport
        private final ActiveObjects ao;

        @Inject
        public URJiraStatusService(ActiveObjects ao)
        {
            this.ao = checkNotNull(ao);
        }

        @Override
        public URJiraStatus add(String URStatus, String jiraStatus)
        {
            final URJiraStatus urJiraStatus = ao.create(URJiraStatus.class);
            urJiraStatus.setJiraStatus(jiraStatus);
            urJiraStatus.setURStatus(URStatus);
            urJiraStatus.save();
            return urJiraStatus;
        }

        @Override
        public List<URJiraStatus> all()
        {
            return newArrayList(ao.find(URJiraStatus.class));
        }
    }
