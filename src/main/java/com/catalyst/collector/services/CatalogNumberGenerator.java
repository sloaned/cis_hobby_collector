package com.catalyst.collector.services;

/**
 * Created by gstringfellow on 11/4/2015.
 */

import java.io.Serializable;

import com.catalyst.collector.entities.Collectible;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.SequenceGenerator;
public class CatalogNumberGenerator
        extends SequenceGenerator
{
    @Override
    public Serializable generate(SessionImplementor session, Object obj)
    {
        Collectible c =(Collectible) obj;
        // generate your custom sequence here
        return c.getName().substring(0,3).toUpperCase()+"-"+c.hashCode(); // In this example, return an int
    }
}
