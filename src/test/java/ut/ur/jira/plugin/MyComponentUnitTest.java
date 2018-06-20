package ut.ur.jira.plugin;

import org.junit.Test;
import ur.jira.plugin.api.MyPluginComponent;
import ur.jira.plugin.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}