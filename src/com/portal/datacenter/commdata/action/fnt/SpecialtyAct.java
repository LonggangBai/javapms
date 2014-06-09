package com.portal.datacenter.commdata.action.fnt;

import com.javapms.basic.utils.ResponseUtils;
import com.portal.datacenter.commdata.entity.Specialty;
import com.portal.datacenter.commdata.service.SpecialtyService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SpecialtyAct {
    @Autowired
    private SpecialtyService specialtyService;

    @RequestMapping(value = {"/specialChild.jsp"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public void specialChild(Integer specialId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
            throws JSONException {
        List<Specialty> specList = this.specialtyService
                .getSpecialtyChild(specialId);
        JSONObject json = new JSONObject(ResponseUtils.listToJson(specList));
        ResponseUtils.renderJson(response, json.toString());
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.datacenter.commdata.action.fnt.SpecialtyAct

 * JD-Core Version:    0.7.0.1

 */