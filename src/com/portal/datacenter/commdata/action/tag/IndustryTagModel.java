package com.portal.datacenter.commdata.action.tag;

import com.portal.datacenter.commdata.entity.Industry;
import com.portal.datacenter.commdata.service.IndustryService;
import com.portal.sysmgr.entity.Site;
import com.portal.sysmgr.utils.TagModelTools;
import com.portal.sysmgr.utils.ViewTools;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndustryTagModel
        implements TemplateDirectiveModel {
    public static final String PARAM_PARENT_ID = "parentId";
    @Autowired
    private IndustryService industryService;

    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
            throws TemplateException, IOException {
        Site site = ViewTools.getSite(env);
        Integer parentId = TagModelTools.getInt("parentId", params);
        List<Industry> industryList = new ArrayList();
        if (parentId != null) {
            industryList = this.industryService.getIndustryChild(parentId);
        } else {
            industryList = this.industryService.getIndustryList(null);
        }
        Map<String, TemplateModel> paramWrap = new HashMap(
                params);
        paramWrap.put("list", ObjectWrapper.DEFAULT_WRAPPER.wrap(industryList));
        Map<String, TemplateModel> origMap =
                TagModelTools.addParamsToVariable(env, paramWrap);
        body.render(env.getOut());
        ViewTools.includePagination(site, params, env);
        TagModelTools.removeParamsFromVariable(env, paramWrap, origMap);
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.datacenter.commdata.action.tag.IndustryTagModel

 * JD-Core Version:    0.7.0.1

 */