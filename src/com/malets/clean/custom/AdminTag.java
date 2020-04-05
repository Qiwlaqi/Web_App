package com.malets.clean.custom;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class AdminTag extends TagSupport {
    @Override
    public int doStartTag() throws JspException {
        if (pageContext.getSession().getAttribute("role").equals("admin")){
            System.out.println("admin");
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }

    @Override public int doEndTag() throws JspException
    {   return EVAL_PAGE; }

}
