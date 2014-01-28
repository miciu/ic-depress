package org.impressivecode.depress.its.jiraonline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.impressivecode.depress.its.ITSStatus;
import org.impressivecode.depress.its.jiraonline.model.JiraOnlineFilterListItem;

public class MapperState extends MapperAbstractCustomField {

    public MapperState(List<JiraOnlineFilterListItem> fieldList) {
        super(fieldList);
    }

    private static final String JIRA_STATUS = "depress.its.jiraonline.statusList";

    @Override
    protected String getMapperModelString() {
        return JIRA_STATUS;
    }
    
    @Override
    protected Collection<String> getImplementedMappings() {
        Collection<String> statuses = new ArrayList<String>();
        for (ITSStatus statusEnum : ITSStatus.values()) {
            statuses.add(statusEnum.toString());
        }
        return statuses;
    }

    @Override
    protected String getParserValue(String state) {
        return JiraOnlineAdapterParser.parseStatusFromEnum(state).toString();
    }
}