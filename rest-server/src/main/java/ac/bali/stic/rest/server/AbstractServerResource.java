package ac.bali.stic.rest.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import java.io.IOException;
import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.representation.Variant;
import org.restlet.resource.ServerResource;

public class AbstractServerResource extends ServerResource
{
    protected Representation toRepresentation( Object object )
    {
        Variant preferredVariant = getConnegService().getPreferredVariant( getVariants(), getRequest(), getMetadataService() );
        MediaType preferredMediaType = preferredVariant.getMediaType();
        if( preferredMediaType == MediaType.APPLICATION_JSON )
        {
            return new JacksonRepresentation( preferredMediaType, object );
        }
        else if( preferredMediaType == MediaType.TEXT_XML
                 || preferredMediaType == MediaType.APPLICATION_XML )
        {
            XmlMapper xmlMapper = new XmlMapper();
            TypeFactory typeFactory = TypeFactory.defaultInstance();
            AnnotationIntrospector introspector = new JaxbAnnotationIntrospector(typeFactory);
            xmlMapper.setAnnotationIntrospectors( introspector, introspector );

            try
            {
                return new StringRepresentation( xmlMapper.writeValueAsString( object ), preferredMediaType );
            }
            catch( JsonProcessingException e )
            {
                throw new IllegalArgumentException( e );
            }
        }

        return null;
    }

    protected <T> T toDomainObject( Representation representation, Class<T> type )
    {
        MediaType mediaType = representation.getMediaType();
        if( mediaType == MediaType.APPLICATION_JSON )
        {
            return toObject( representation, type );
        }
        else if( mediaType == MediaType.TEXT_XML
                 || mediaType == MediaType.APPLICATION_XML )
        {
            XmlMapper xmlMapper = new XmlMapper();
            TypeFactory typeFactory = TypeFactory.defaultInstance();
            AnnotationIntrospector introspector = new JaxbAnnotationIntrospector(typeFactory);
            xmlMapper.setAnnotationIntrospectors( introspector, introspector );

            try
            {
                return xmlMapper.readValue(representation.getText(), type);
            }
            catch( IOException e )
            {
                throw new IllegalArgumentException( e );
            }
        }

        return null;
    }
}
