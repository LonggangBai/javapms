package com.portal.datacenter.commdata.action.fnt;

import com.javapms.basic.utils.ResponseUtils;
import com.portal.datacenter.commdata.entity.Metier;
import com.portal.datacenter.commdata.service.MetierService;
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
public class MetierAct {
    @Autowired
    private MetierService metierService;

    @RequestMapping(value = {"/metierChild.jsp"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public void metierChild(Integer metierId, HttpServletRequest request, HttpServletResponse response, ModelMap model)
            throws JSONException {
        List<Metier> metierList = this.metierService.getMetierChild(metierId);
        JSONObject json = new JSONObject(ResponseUtils.listToJson(metierList));
        ResponseUtils.renderJson(response, json.toString());
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.datacenter.commdata.action.fnt.MetierAct

 * JD-Core Version:    0.7.0.1

 */