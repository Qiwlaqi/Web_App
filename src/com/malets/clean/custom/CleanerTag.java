package com.malets.clean.custom;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class CleanerTag extends TagSupport {
    @Override
    public int doStartTag() {
        if (pageContext.getSession().getAttribute("role").equals("cleaner")){
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }

    @Override public int doEndTag() 
    {   return EVAL_PAGE; }

}
