/*
 * Copyright (C) 2013 4th Line GmbH, Switzerland
 *
 * The contents of this file are subject to the terms of either the GNU
 * Lesser General Public License Version 2 or later ("LGPL") or the
 * Common Development and Distribution License Version 1 or later
 * ("CDDL") (collectively, the "License"). You may not use this file
 * except in compliance with the License. See LICENSE.txt for more
 * information.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 */

package org.jupnp.support.avtransport.callback;

import org.jupnp.controlpoint.ActionCallback;
import org.jupnp.model.action.ActionInvocation;
import org.jupnp.model.meta.Service;
import org.jupnp.model.types.UnsignedIntegerFourBytes;

import java.util.logging.Logger;

/**
 * @author Christian Bauer - Initial Contribution
 * @author Amit Kumar Mondal - Code Refactoring
 */
public abstract class SetAVTransportURI extends ActionCallback {

    private final Logger logger = Logger.getLogger(SetAVTransportURI.class.getName());

    public SetAVTransportURI(Service<?, ?> service, String uri) {
        this(new UnsignedIntegerFourBytes(0), service, uri, null);
    }

    public SetAVTransportURI(Service<?, ?> service, String uri, String metadata) {
        this(new UnsignedIntegerFourBytes(0), service, uri, metadata);
    }

    public SetAVTransportURI(UnsignedIntegerFourBytes instanceId, Service<?, ?> service, String uri) {
        this(instanceId, service, uri, null);
    }

    public SetAVTransportURI(UnsignedIntegerFourBytes instanceId, Service<?, ?> service, String uri, String metadata) {
        super(new ActionInvocation<>(service.getAction("SetAVTransportURI")));
        logger.fine("Creating SetAVTransportURI action for URI: " + uri);
        getActionInvocation().setInput("InstanceID", instanceId);
        getActionInvocation().setInput("CurrentURI", uri);
        getActionInvocation().setInput("CurrentURIMetaData", metadata);
    }

    @Override
    public void success(ActionInvocation invocation) {
        logger.fine("Execution successful");
    }
}