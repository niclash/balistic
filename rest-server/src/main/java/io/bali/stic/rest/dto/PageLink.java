package io.bali.stic.rest.dto;

import io.bali.stic.rest.Link;

public class PageLink extends Link
{
    private final int pageNo;

    public PageLink( int pageNo, String linkValue )
    {
        super(linkValue);
        this.pageNo = pageNo;
    }

    public int getPage()
    {
        return pageNo;
    }

}
