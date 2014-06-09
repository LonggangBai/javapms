package com.portal.datacenter.commdata.action;

import com.javapms.basic.page.Pagination;
import com.javapms.basic.page.SimplePage;
import com.portal.datacenter.commdata.entity.ForeignLang;
import com.portal.datacenter.commdata.service.ForeignLangService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ForeignLangAct {
    private static final Logger log = LoggerFactory.getLogger(ForeignLangAct.class);
    @Autowired
    private ForeignLangService service;

    @RequiresPermissions({"admin:foreignlang:list"})
    @RequestMapping({"/foreignlang/v_list.do"})
    public String list(Integer pageNo, HttpServletRequest request, ModelMap model) {
        Pagination pagination = this.service.getPage(SimplePage.cpn(pageNo), 20);
        model.addAttribute("pagination", pagination);
        model.addAttribute("pageNo", Integer.valueOf(pagination.getPageNo()));
        return "foreignlang/list";
    }

    @RequiresPermissions({"admin:foreignlang:add"})
    @RequestMapping({"/foreignlang/v_add.do"})
    public String add(ModelMap model) {
        return "foreignlang/add";
    }

    @RequiresPermissions({"admin:foreignlang:edit"})
    @RequestMapping({"/foreignlang/v_edit.do"})
    public String edit(Integer id, Integer pageNo, HttpServletRequest request, ModelMap model) {
        model.addAttribute("foreignLang", this.service.findById(id));
        model.addAttribute("pageNo", pageNo);
        return "foreignlang/edit";
    }

    @RequiresPermissions({"admin:foreignlang:save"})
    @RequestMapping({"/foreignlang/o_save.do"})
    public String save(ForeignLang bean, HttpServletRequest request, ModelMap model) {
        bean = this.service.save(bean);
        log.info("save ForeignLang id={}", bean.getId());
        return "redirect:v_list.do";
    }

    @RequiresPermissions({"admin:foreignlang:update"})
    @RequestMapping({"/foreignlang/o_update.do"})
    public String update(ForeignLang bean, Integer pageNo, HttpServletRequest request, ModelMap model) {
        bean = this.service.update(bean);
        log.info("update ForeignLang id={}.", bean.getId());
        return list(pageNo, request, model);
    }

    @RequiresPermissions({"admin:foreignlang:delete"})
    @RequestMapping({"/foreignlang/o_delete.do"})
    public String delete(Integer[] ids, Integer pageNo, HttpServletRequest request, ModelMap model) {
        ForeignLang[] beans = this.service.deleteByIds(ids);
        for (ForeignLang bean : beans) {
            log.info("delete ForeignLang id={}", bean.getId());
        }
        return list(pageNo, request, model);
    }
}



/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\

 * Qualified Name:     com.portal.datacenter.commdata.action.ForeignLangAct

 * JD-Core Version:    0.7.0.1

 */