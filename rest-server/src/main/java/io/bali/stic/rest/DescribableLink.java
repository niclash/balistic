package io.bali.stic.rest;

public class DescribableLink extends Link
{
    private final String description;

    public DescribableLink( String description, String linkValue )
    {
        super( linkValue );
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    static Link createRelativeLink( String segment, String description, String base )
    {
        return new DescribableLink(description, base + segment );
    }
}
